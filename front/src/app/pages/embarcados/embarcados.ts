export class Embarcados {
    constructor(
        public id?: number,
        public dataCriacao?: Date,
        public dataUpdate?: Date,
        public descricaoEmbarcado?: string,
        public firmware?: string,
        public ipEmbarcado?: string,
        public ipGateway?: string,
        public mac?: string,
        public passwordWifi?: string,
        public ssid?: string,
        public status?: string,
        public tipoRede?: string,
        public ambienteId?: number
    ) {

    }
}