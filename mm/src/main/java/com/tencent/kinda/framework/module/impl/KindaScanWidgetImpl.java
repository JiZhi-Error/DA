package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KScanWidget;
import com.tencent.kinda.gen.VoidStringStringBinaryCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.y;
import com.tenpay.ndk.Encrypt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KindaScanWidgetImpl implements KScanWidget {
    private static final String TAG = "KindaScanWidgetImpl";
    private boolean isDismissOnScanFinish = true;
    private VoidStringStringBinaryCallback mCallback;
    private IListener mScanBankCardResultListener = new IListener<tg>() {
        /* class com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl.AnonymousClass2 */

        {
            AppMethodBeat.i(160758);
            this.__eventId = tg.class.getName().hashCode();
            AppMethodBeat.o(160758);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(tg tgVar) {
            AppMethodBeat.i(18650);
            boolean callback = callback(tgVar);
            AppMethodBeat.o(18650);
            return callback;
        }

        public boolean callback(tg tgVar) {
            AppMethodBeat.i(18649);
            if (!Util.isNullOrNil(tgVar.dZH.cardId) && KindaScanWidgetImpl.this.mCallback != null) {
                String str = tgVar.dZH.cardId;
                Bitmap bitmap = tgVar.dZH.dZI;
                String replaceAll = str.replaceAll("-", "").replaceAll(" ", "");
                KindaScanWidgetImpl.this.mCallback.call(KindaScanWidgetImpl.access$100(KindaScanWidgetImpl.this, replaceAll), replaceAll, KindaScanWidgetImpl.this.getBitmapByte(bitmap));
            }
            KindaScanWidgetImpl.this.mScanBankCardResultListener.dead();
            AppMethodBeat.o(18649);
            return false;
        }
    };
    private IListener scanBankCardConfirmResultListener = new IListener<tf>() {
        /* class com.tencent.kinda.framework.module.impl.KindaScanWidgetImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160757);
            this.__eventId = tf.class.getName().hashCode();
            AppMethodBeat.o(160757);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(tf tfVar) {
            AppMethodBeat.i(18648);
            boolean callback = callback(tfVar);
            AppMethodBeat.o(18648);
            return callback;
        }

        public boolean callback(tf tfVar) {
            AppMethodBeat.i(18647);
            if (tfVar.dZF.action == 1 && !Util.isNullOrNil(tfVar.dZF.cardNum) && KindaScanWidgetImpl.this.mCallback != null) {
                String str = tfVar.dZF.cardNum;
                Bitmap bitmap = tfVar.dZF.dZG;
                String replaceAll = str.replaceAll("-", "").replaceAll(" ", "");
                KindaScanWidgetImpl.this.mCallback.call(KindaScanWidgetImpl.access$100(KindaScanWidgetImpl.this, replaceAll), replaceAll, KindaScanWidgetImpl.this.getBitmapByte(bitmap));
            }
            KindaScanWidgetImpl.this.scanBankCardConfirmResultListener.dead();
            AppMethodBeat.o(18647);
            return false;
        }
    };

    public KindaScanWidgetImpl() {
        AppMethodBeat.i(18651);
        AppMethodBeat.o(18651);
    }

    static /* synthetic */ String access$100(KindaScanWidgetImpl kindaScanWidgetImpl, String str) {
        AppMethodBeat.i(18655);
        String encryptDataWithHash = kindaScanWidgetImpl.getEncryptDataWithHash(str);
        AppMethodBeat.o(18655);
        return encryptDataWithHash;
    }

    @Override // com.tencent.kinda.gen.KScanWidget
    public void setHandlerImpl(VoidStringStringBinaryCallback voidStringStringBinaryCallback) {
        this.mCallback = voidStringStringBinaryCallback;
    }

    @Override // com.tencent.kinda.gen.KScanWidget
    public void scan(String str) {
        AppMethodBeat.i(18652);
        Context context = KindaContext.get();
        if (context == null) {
            Log.e(TAG, "KindaScanWidgetImpl scan() KindaContext.get() return null!");
            AppMethodBeat.o(18652);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", this.isDismissOnScanFinish);
        intent.putExtra("bank_card_owner", str);
        intent.addFlags(536870912);
        c.b(context, "scanner", ".ui.ScanCardUI", intent);
        this.scanBankCardConfirmResultListener.alive();
        this.mScanBankCardResultListener.alive();
        AppMethodBeat.o(18652);
    }

    @Override // com.tencent.kinda.gen.KScanWidget
    public void dismissOnScanFinish(boolean z) {
        this.isDismissOnScanFinish = !z;
    }

    private String getEncryptDataWithHash(String str) {
        AppMethodBeat.i(18653);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(18653);
            return null;
        }
        Encrypt encrypt = new Encrypt();
        encrypt.setTimeStamp(y.hhp());
        b.hgC();
        if (b.hgD()) {
            String encryptPasswdWithRSA2048 = encrypt.encryptPasswdWithRSA2048(str);
            AppMethodBeat.o(18653);
            return encryptPasswdWithRSA2048;
        }
        String encryptPasswd = encrypt.encryptPasswd(str);
        AppMethodBeat.o(18653);
        return encryptPasswd;
    }

    public byte[] getBitmapByte(Bitmap bitmap) {
        AppMethodBeat.i(18654);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e2) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(18654);
        return byteArray;
    }
}
