package com.devanshi.tambola.ticketgenerator.app.apis;

class ServerConfig {
    static String BASE_URL = "http://142.93.214.248/jayastudio/public/index.php/api/";
    static final String LOGIN_API = "v1/userLogin";
    static final String LIST_TICKET = "v1/listTicket";
    static final String LIST_TICKET_TRANSACTION = "v1/listTicketTransaction";
    static final String LIST_TICKET_SERIAL = "v1/listTicketSerial";
    static final String LIST_TICKET_COLUMN = "v1/listTicketColumn";
    static final String LIST_ADD_UPDATE_TICKET = "v1/addUpdateTicket";
    static final String GET_PLAYER_TICKET = "v1/playerList";
    static final String GET_CITY_LIST = "v1/listCity";
    static final String ADD_UPDATE_PLAYER = "v1/addUpdatePlayer";
    static final String ADD_TICKET_TRANSACTION = "v1/addUpdateTicketTransaction";
    static final String ADD_CLAIM_REQUEST = "v1/claimRequestAdd";
    static final String LIST_CLAIM_REQUEST = "v1/claimRequestList";
    static final String LIST_CLAIM_TRANSACTION = "v1/claimTransationList";
    static final String LIST_CLAIM_GAME = "v1/claimGameList";
    static final String LIST_PLAYER = "user/listPlayer";
    static final String WALLET_RECHARGE = "user/walletRecharge";
    static final String WALLET_RECHARGE_LIST = "user/walletRechargeList";
}
