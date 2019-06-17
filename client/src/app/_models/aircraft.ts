export class Aircraft {
    id: number;
    size: Size;
    maxSeats: number;
    maxLuggageSize: number;


  constructor(size: Size, maxSeats: number, maxLuggageSize: number) {
    this.size = size;
    this.maxSeats = maxSeats;
    this.maxLuggageSize = maxLuggageSize;
  }
}
