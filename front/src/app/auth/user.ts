export class User {
    constructor(
        public id?: number,
        public dataCriacao?: Date,
        public dataUpdate?: Date,
        public celular?: string,
        public codigoRfid?: string,
        public email?: string,
        public nome?: string,
        public operador?: string,
        public password?: string,
        public confirmedPassword?: string,
        public status?: string,
        public token?: string
    ) {}
}