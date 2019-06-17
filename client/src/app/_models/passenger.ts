export class Passenger {
  id: number;
  points: number;
  creditCardNumber: string;
  birthDate: Date;


  constructor(id: number, points: number, creditCardNumber: string, birthDate: Date) {
    this.id = id;
    this.points = points;
    this.creditCardNumber = creditCardNumber;
    this.birthDate = birthDate;
  }
}
