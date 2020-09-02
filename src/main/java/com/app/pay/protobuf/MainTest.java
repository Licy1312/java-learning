package com.app.pay.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author lee
 * @description:
 * @date:2019-08-14
 */
public class MainTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {

        RequestOrder.PayOrderInfo payOrderInfo = RequestOrder.PayOrderInfo.newBuilder()
                .setRequestId(2019081311)
                .setCheckBit("abc123")
                .setBizContent("{\"TxnSrlNo\":\"1234567890\",\"PlatCstId\":\"270464480\",\"TxnDt\":\"20190808\",\"TxnTs\":\"100023560\",\"AcctNo\":\"1234567890\"}")
                .build();

        byte[] payOrderByte = payOrderInfo.toByteArray();

        RequestOrder.PayOrderInfo receivedMessage = RequestOrder.PayOrderInfo.parseFrom(payOrderByte);

        System.out.println(receivedMessage.toString());
    }
}
