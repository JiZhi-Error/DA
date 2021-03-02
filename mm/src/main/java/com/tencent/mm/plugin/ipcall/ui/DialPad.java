package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    private static final String[] ysQ = {"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", AppEventsConstants.EVENT_PARAM_VALUE_NO, "#"};
    private static final String[] ysR = {"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    private boolean ysP = false;
    private Map<Integer, DialNumberButton> ysS = new HashMap();
    private Map<String, DialNumberButton> ysT = new HashMap();
    private Map<Integer, View> ysU = new HashMap();
    private a ysV;

    public interface a {
        void aCc(String str);

        void aCd(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25575);
        init();
        AppMethodBeat.o(25575);
    }

    public void setDialButtonClickListener(a aVar) {
        this.ysV = aVar;
    }

    private void init() {
        AppMethodBeat.i(25576);
        LayoutInflater.from(getContext()).inflate(R.layout.zp, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.dimen.a9r);
        a(R.id.bqa, ysQ[0], ysR[0], dimensionPixelSize);
        a(R.id.bqg, ysQ[1], ysR[1], dimensionPixelSize);
        a(R.id.bqf, ysQ[2], ysR[2], dimensionPixelSize);
        a(R.id.bq9, ysQ[3], ysR[3], dimensionPixelSize);
        a(R.id.bq8, ysQ[4], ysR[4], dimensionPixelSize);
        a(R.id.bqd, ysQ[5], ysR[5], dimensionPixelSize);
        a(R.id.bqb, ysQ[6], ysR[6], dimensionPixelSize);
        a(R.id.bq7, ysQ[7], ysR[7], dimensionPixelSize);
        a(R.id.bq_, ysQ[8], ysR[8], dimensionPixelSize);
        a(R.id.bqe, ysQ[9], ysR[9], (float) getContext().getResources().getDimensionPixelSize(R.dimen.a9u));
        a(R.id.bqh, ysQ[10], ysR[10], dimensionPixelSize);
        a(R.id.bqc, ysQ[11], ysR[11], (float) getContext().getResources().getDimensionPixelSize(R.dimen.a9v));
        this.ysU.put(Integer.valueOf((int) R.id.bsj), findViewById(R.id.bsj));
        this.ysU.put(Integer.valueOf((int) R.id.bso), findViewById(R.id.bso));
        this.ysU.put(Integer.valueOf((int) R.id.bsm), findViewById(R.id.bsm));
        this.ysU.put(Integer.valueOf((int) R.id.bsf), findViewById(R.id.bsf));
        this.ysU.put(Integer.valueOf((int) R.id.bse), findViewById(R.id.bse));
        for (View view : this.ysU.values()) {
            if (this.ysP) {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.ab5));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.ls));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
        AppMethodBeat.o(25576);
    }

    private void a(int i2, String str, String str2, float f2) {
        AppMethodBeat.i(25577);
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i2);
        dialNumberButton.il(str, str2);
        dialNumberButton.setNumberTextSize$255e752(f2);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.setInTalkUIMode(this.ysP);
        this.ysS.put(Integer.valueOf(i2), dialNumberButton);
        this.ysT.put(str, dialNumberButton);
        AppMethodBeat.o(25577);
    }

    public void setTalkUIMode(boolean z) {
        AppMethodBeat.i(25578);
        this.ysP = z;
        for (DialNumberButton dialNumberButton : this.ysS.values()) {
            dialNumberButton.setInTalkUIMode(z);
        }
        for (View view : this.ysU.values()) {
            if (this.ysP) {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.ab5));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.ls));
            }
        }
        AppMethodBeat.o(25578);
    }

    public void onClick(View view) {
        AppMethodBeat.i(25579);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.ysS.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = this.ysS.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            c eaD = i.eaD();
            int aUD = c.aUD(numberText);
            if (aUD != -1 && c.fKK()) {
                AudioManager audioManager = com.tencent.mm.plugin.audio.c.a.cea().audioManager;
                if (audioManager == null) {
                    audioManager = (AudioManager) c.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (eaD.Hhv) {
                        try {
                            if (eaD.Hhw != null) {
                                eaD.Hhw.startTone(aUD, 250);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(25579);
                            throw th;
                        }
                    }
                }
            }
            if (this.ysV != null) {
                this.ysV.aCc(!Util.isNullOrNil(numberText) ? numberText : otherText);
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25579);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(25580);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
        if (this.ysS.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = this.ysS.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            if (this.ysV != null) {
                a aVar = this.ysV;
                if (!Util.isNullOrNil(numberText)) {
                    otherText = numberText;
                }
                aVar.aCd(otherText);
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(25580);
            return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/ipcall/ui/DialPad", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(25580);
        return false;
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(25581);
        Log.i("MicroMsg.DialPad", "onViewAdded, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.o(25581);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.i(25582);
        Log.i("MicroMsg.DialPad", "onViewRemoved, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.o(25582);
    }
}
