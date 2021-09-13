package com.devanshi.tambola.ticketgenerator.app.apis;

import com.devanshi.tambola.ticketgenerator.app.model.*;

import okhttp3.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIInterface {

    @FormUrlEncoded
    @POST(ServerConfig.LOGIN_API)
    Call<UserLoginModel> loginApi(@Field("email") String username,
                             @Field("password") String password);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_TICKET)
    Call<ListTicketModel> listTicketApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_TICKET_SERIAL)
    Call<TicketSerialModel> listTicketSerialApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_TICKET_COLUMN)
    Call<TicketColumnModel> listTicketColumnApi(@Field("serial_index_id") int ticket_serial_index);

    @Multipart
    @POST(ServerConfig.LIST_ADD_UPDATE_TICKET)
    Call<AddUpdateTicketModel> updateTicketApi(@Part("serial_index_id") RequestBody serial_index_id,
                                               @Part("column_id") RequestBody column_id,
                                               @Part("from_serial_no") RequestBody from_serial_no,
                                               @Part("to_serial_no") RequestBody to_serial_no,
                                               @Part MultipartBody.Part ticket_image,
                                               @Part("ticket_id") RequestBody ticket_id);

    @Multipart
    @POST(ServerConfig.LIST_ADD_UPDATE_TICKET)
    Call<AddUpdateTicketModel> addTicketApi(@Part("serial_index_id") RequestBody serial_index_id,
                                               @Part("column_id") RequestBody column_id,
                                               @Part("from_serial_no") RequestBody from_serial_no,
                                               @Part("to_serial_no") RequestBody to_serial_no,
                                               @Part MultipartBody.Part ticket_image);

    @FormUrlEncoded
    @POST(ServerConfig.GET_PLAYER_TICKET)
    Call<CustomerRespModel> getPlayerListApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.GET_CITY_LIST)
    Call<CityRespModel> getCityListApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.ADD_UPDATE_PLAYER)
    Call<AddUpdatePlayerRespModel> updatePlayerApi(@Field("name") String name,
                                     @Field("contact_no") String contact_no,
                                     @Field("palyer_id") String palyer_id,
                                     @Field("city_id") int city_id);
    @FormUrlEncoded
    @POST(ServerConfig.ADD_UPDATE_PLAYER)
    Call<AddUpdatePlayerRespModel> addPlayerApi(@Field("name") String name,
                                     @Field("contact_no") String contact_no,
                                     @Field("city_id") int city_id);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_TICKET_TRANSACTION)
    Call<TicketTransactionRespModel> listTicketTransactionApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_TICKET)
    Call<ListTicketModel> listTicketForTicketTransactionApi(@Field("serial_index_id") int serial_index_id,
                                                            @Field("column_id") int column_id);

    @FormUrlEncoded
    @POST(ServerConfig.ADD_TICKET_TRANSACTION)
    Call<NewTicketTransactionRespModel> addTicketTransaction(@Field("player_id") String player_id,
                                               @Field("serial_index_id") int serial_index_id,
                                               @Field("column_id") int column_id,
                                               @Field("ticket_id") int ticket_id,
                                               @Field("created_by_id") int created_by_id,
                                               @Field("game_on") String game_on,
                                               @Field("amount") String amount,
                                               @Field("transaction_id") String transaction_id,
                                               @Field("payed_by") String payed_by);

    @FormUrlEncoded
    @POST(ServerConfig.ADD_CLAIM_REQUEST)
    Call<ClaimResponseModel> addClaimRequest(@Field("game_id") String game_id,
                                               @Field("claim_type") String claim_type,
                                               @Field("transactions_id") String transactions_id);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_CLAIM_TRANSACTION)
    Call<ClaimTransactionListModel> getClaimTransactionList(@Field("game_id") String game_id);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_CLAIM_REQUEST)
    Call<ClaimListModel> listClaimRequestApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_CLAIM_GAME)
    Call<GameIdModel> gameIdRequestApi(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.LIST_PLAYER)
    Call<PlayerNameModel> listPlayerAPI(@Field("username") String username);

    @FormUrlEncoded
    @POST(ServerConfig.WALLET_RECHARGE)
    Call<NewWalletRechargeModel> walletRechargeApi(@Field("recharged_by") Integer recharged_by,
                                            @Field("user_id") Integer user_id,
                                            @Field("amount") String amount,
                                            @Field("type") String type,
                                            @Field("description") String description);

    @FormUrlEncoded
    @POST(ServerConfig.WALLET_RECHARGE_LIST)
    Call<WalletRechargeModel> listWalletRechargeApi(@Field("user_id") String user_id);
}
