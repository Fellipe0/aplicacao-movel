export class Ambiente {
    constructor(
        public id?: number,
        public dataCriacao?: Date,
        public dataUpdate?: Date,
        public capacidade?: number,
        public descricao?: string,
        public ipCamera?: string,
        public nomeAmbiente?: string,
        public tipoAmbiente?: string,
        public blocoId?: number
    ){}
}