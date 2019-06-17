export class Airport {
  id: number;
  name: string;
  numberOfCurrentAircraft: number;
  freeSlotsSmallAircraft: number;
  freeSlotsMediumAirCraft: number;
  freeSlotsBig2Engines: number;
  freeSlotsBig4Engines: number;


  constructor(name: string, numberOfCurrentAircraft: number, freeSlotsSmallAircraft: number, freeSlotsMediumAirCraft: number, freeSlotsBig2Engines: number, freeSlotsBig4Engines: number) {
    this.name = name;
    this.numberOfCurrentAircraft = numberOfCurrentAircraft;
    this.freeSlotsSmallAircraft = freeSlotsSmallAircraft;
    this.freeSlotsMediumAirCraft = freeSlotsMediumAirCraft;
    this.freeSlotsBig2Engines = freeSlotsBig2Engines;
    this.freeSlotsBig4Engines = freeSlotsBig4Engines;
  }
}
