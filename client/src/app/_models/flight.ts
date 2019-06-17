export class Flight {
  id: number;
  numberOfPassengers: number;
  numberOfFreeSeats: number;
  originAirportId: number;
  destinationAirportId: number;
  startDate: Date;
  finishDate: Date;
  flightId: number;


  constructor(numberOfPassengers: number, numberOfFreeSeats: number, originAirportId: number, destinationAirportId: number, startDate: Date, finishDate: Date, flightId: number) {
    this.numberOfPassengers = numberOfPassengers;
    this.numberOfFreeSeats = numberOfFreeSeats;
    this.originAirportId = originAirportId;
    this.destinationAirportId = destinationAirportId;
    this.startDate = startDate;
    this.finishDate = finishDate;
    this.flightId = flightId;
  }

}
