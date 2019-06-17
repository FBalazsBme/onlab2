export class Pilot {
  name: string;
  licenseType: Size;
  id: number;

  constructor(name: string, licenseType: Size, id: number = 1) {
    this.name = name;
    this.licenseType = licenseType;
    this.id = id;
  }
}
