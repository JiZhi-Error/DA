package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardReg {
    private static final String TAG = "MyTag";

    public static int recognizeBankCardInit(int i2, int i3, boolean z) {
        AppMethodBeat.i(73262);
        int recognizeBankCardInit = BankCardRecog.recognizeBankCardInit(i2, i3, z);
        AppMethodBeat.o(73262);
        return recognizeBankCardInit;
    }

    public static int recognizeBankCardProcess(byte[] bArr, BankCardInfo bankCardInfo, boolean[] zArr) {
        AppMethodBeat.i(73263);
        int recognizeBankCardProcess = BankCardRecog.recognizeBankCardProcess(bArr, bankCardInfo, zArr);
        AppMethodBeat.o(73263);
        return recognizeBankCardProcess;
    }

    public static String getBankCardSegmentNumber(String str, int i2, int[] iArr) {
        AppMethodBeat.i(73264);
        LogUtil.d(TAG, "getBankCardSegmentNumber");
        LogUtil.d(TAG, "cardNum=".concat(String.valueOf(str)));
        Encrypt encrypt = new Encrypt();
        String desedeDecode = encrypt.desedeDecode(str, encrypt.getRandomKey());
        LogUtil.d(TAG, "cardNum=".concat(String.valueOf(desedeDecode)));
        String bankCardSegmentNumber = BankCardRecog.getBankCardSegmentNumber(desedeDecode, i2, iArr);
        LogUtil.d(TAG, bankCardSegmentNumber);
        String desedeEncode = encrypt.desedeEncode(bankCardSegmentNumber, encrypt.getRandomKey());
        AppMethodBeat.o(73264);
        return desedeEncode;
    }

    public static int recognizeBankCardRelease() {
        AppMethodBeat.i(73265);
        int recognizeBankCardRelease = BankCardRecog.recognizeBankCardRelease();
        AppMethodBeat.o(73265);
        return recognizeBankCardRelease;
    }

    public static int recognizeBankCardGetVersion() {
        AppMethodBeat.i(73266);
        int recognizeBankCardGetVersion = BankCardRecog.recognizeBankCardGetVersion();
        AppMethodBeat.o(73266);
        return recognizeBankCardGetVersion;
    }
}
