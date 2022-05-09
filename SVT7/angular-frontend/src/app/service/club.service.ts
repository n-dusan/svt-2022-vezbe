import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';

@Injectable()
export class ClubService {

  constructor(
    private apiService: ApiService,
    private config: ConfigService
  ) {
  }

  getClubs() {
    return this.apiService.get(this.config.club_url);
  }

}
