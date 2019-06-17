export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    staff: boolean;
    admin: boolean;
    token: string;


  constructor(
               username: string,
               password: string,
               id: number = 1,
               firstName: string = 'default',
               lastName: string = 'default',
               staff: boolean = false,
               admin: boolean = false,
               token: string= 'default') {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.staff = staff;
    this.admin = admin;
    this.token = token;
  }

  public getadmin(): boolean {
      return this.admin;
      }
}
