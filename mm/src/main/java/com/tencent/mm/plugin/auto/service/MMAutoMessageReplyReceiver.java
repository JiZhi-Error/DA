package com.tencent.mm.plugin.auto.service;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.auto.a.a;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class MMAutoMessageReplyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        Intent intent2;
        CharSequence charSequence;
        AppMethodBeat.i(21162);
        String stringExtra = IntentUtil.getStringExtra(intent, "key_username");
        if (stringExtra == null) {
            AppMethodBeat.o(21162);
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            bundle = RemoteInput.getResultsFromIntent(intent);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    intent2 = null;
                } else {
                    ClipDescription description = clipData.getDescription();
                    if (!description.hasMimeType("text/vnd.android.intent")) {
                        intent2 = null;
                    } else if (!description.getLabel().equals("android.remoteinput.results")) {
                        intent2 = null;
                    } else {
                        intent2 = clipData.getItemAt(0).getIntent();
                    }
                }
                if (intent2 != null) {
                    bundle = (Bundle) intent2.getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            bundle = null;
        }
        if (bundle != null) {
            charSequence = bundle.getCharSequence("key_voice_reply_text");
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", stringExtra);
            AppMethodBeat.o(21162);
        } else if (!a.ceB()) {
            AppMethodBeat.o(21162);
        } else if (!a.ceC()) {
            Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not open car mode");
            AppMethodBeat.o(21162);
        } else if (!a.ceD()) {
            Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not install auto app");
            AppMethodBeat.o(21162);
        } else {
            b bVar = b.oIG;
            b.Bt(1);
            Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", stringExtra, charSequence.toString());
            g.eir().ad(stringExtra, charSequence.toString(), ab.JG(stringExtra));
            AppMethodBeat.o(21162);
        }
    }
}
