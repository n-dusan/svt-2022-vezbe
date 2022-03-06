package rs.ac.uns.ftn.svtvezbe03.primer05;

import java.util.List;

public interface TeacherRepository {

    List<Teacher> findAll();

    Teacher load(int teacherId);

    boolean insert(final Teacher teacher);

    boolean update(final Teacher teacher);

    boolean delete(final int teacherId);
}
