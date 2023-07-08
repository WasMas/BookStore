import { Role } from './role.enum';

export class User {
  id_user: number | undefined;
  username: string = '';
  password: string = '';
  name: string = '';
  token: string = '';
  role: Role = Role.USER;
}
