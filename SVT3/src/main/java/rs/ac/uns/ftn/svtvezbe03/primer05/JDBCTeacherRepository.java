package rs.ac.uns.ftn.svtvezbe03.primer05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCTeacherRepository implements TeacherRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Teacher> findAll() {
        return jdbcTemplate.query("select * from nastavnici", (rs, rowNum) ->
                new Teacher(
                        rs.getInt("nastavnikId"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("zvanje")
                )
        );
    }

    /**
     * Ucitava podatke o nastavniku na osnovu njegovog id-a
     *
     * @param teacherId identifikator nastavnika
     * @return Teacher ako je operacija uspesna
     */
    @Override
    public Teacher load(int teacherId) {
        Teacher teacher = null;
        try {
            teacher = jdbcTemplate.query("SELECT nastavnikId, ime, prezime, zvanje FROM nastavnici WHERE nastavnikId=" + teacherId, rs -> {
                Teacher retVal = null;
                if (rs.next()) {
                    retVal = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                }
                return retVal;
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return teacher;
    }

    /**
     * Dodaje nastavnika u bazu.
     *
     * @return true ako je operacija uspesna
     */
    @Override
    public boolean insert(Teacher teacher) {
        boolean success = false;
        try {
            int rowsAffected = jdbcTemplate.update("INSERT INTO nastavnici (nastavnikId, ime, prezime, zvanje) VALUES (?, ?, ?, ?)", preparedStatement -> {
                preparedStatement.setInt(1, teacher.getTeacherId());
                preparedStatement.setString(2, teacher.getFirstName());
                preparedStatement.setString(3, teacher.getLastName());
                preparedStatement.setString(4, teacher.getPosition());
            });
            success = rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    /**
     * Dodaje nastavnika u bazu.
     *
     * @return true ako je operacija uspesna
     */
    @Override
    public boolean update(Teacher teacher) {
        boolean success = false;
        try {
            int rowsAffected = jdbcTemplate.update("UPDATE nastavnici SET ime=?, prezime=?, zvanje=? WHERE nastavnikId=?", preparedStatement -> {
                preparedStatement.setString(1, teacher.getFirstName());
                preparedStatement.setString(2, teacher.getLastName());
                preparedStatement.setString(3, teacher.getPosition());
                preparedStatement.setInt(4, teacher.getTeacherId());
            });
            success = rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    /**
     * Azurira nastavnikove podatke u bazi.
     *
     * @return true ako je operacija uspesna
     */
    @Override
    public boolean delete(int teacherId) {
        boolean success = false;
        try {
            int rowsAffected = jdbcTemplate.update("DELETE FROM nastavnici WHERE nastavnikId=?", preparedStatement -> preparedStatement.setInt(1, teacherId));
            success = rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }
}
