package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public final class a extends LinearLayout {
    private List<String> GvY = new ArrayList();
    private VoiceInputLayout.a KdJ = new VoiceInputLayout.a() {
        /* class com.tencent.mm.pluginsdk.ui.websearch.a.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a
        public final void dPW() {
            AppMethodBeat.i(32044);
            a.a(a.this, (int) R.string.hz7);
            AppMethodBeat.o(32044);
        }
    };
    private MMEditText KdO;
    public int Khj = com.tencent.mm.cb.a.fromDPToPix(getContext(), 280);
    private VoiceInputLayout KnI;
    private ImageButton KnJ;
    private Button KnK;
    private VoiceInputScrollView KnO;
    private TextView KnP;
    private long KnQ = 0;
    private float KnS = 0.0f;
    private float KnT = 0.0f;
    private boolean KnU = false;
    private boolean KnV = false;
    private boolean KnW = false;
    private int KnX = 300;
    private boolean KnZ = false;
    private boolean Koa = false;
    private long Kob = 0;
    private long Koc = 0;
    private long Kod = 0;
    private boolean Koe = false;
    private boolean Kof = false;
    private final int Kog = 2;
    private boolean Koh = false;
    private IListener<yz> Kok;
    private VoiceInputLayout.b Kon = new VoiceInputLayout.b() {
        /* class com.tencent.mm.pluginsdk.ui.websearch.a.AnonymousClass5 */

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPN() {
            AppMethodBeat.i(32047);
            a.this.Kob = System.currentTimeMillis();
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(a.this.Kob));
            Log.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(a.this.Kob));
            a.this.KnZ = false;
            a.this.Koa = true;
            a.this.Koh = true;
            a.this.Koc = 0;
            a.this.Kod = 0;
            a.d(a.this);
            a.this.KnP.setVisibility(8);
            a.this.Koa = false;
            a aVar = a.this;
            if (aVar.audioManager != null) {
                aVar.audioManager.setStreamMute(3, true);
            }
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().addFlags(128);
            }
            a.this.han.setVisibility(4);
            a.this.KnJ.setVisibility(4);
            a.this.KnK.setVisibility(8);
            a.this.KdO.setHint(a.this.getResources().getString(R.string.hz5));
            a.this.Kxp.zQ(true);
            AppMethodBeat.o(32047);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPQ() {
            AppMethodBeat.i(32048);
            a.this.Kxp.zQ(false);
            a.this.KdO.setHint((CharSequence) null);
            AppMethodBeat.o(32048);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPR() {
            AppMethodBeat.i(32049);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.Kxp.zQ(false);
            a.this.KdO.setHint((CharSequence) null);
            a.b(a.this, 2);
            AppMethodBeat.o(32049);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPS() {
            AppMethodBeat.i(32050);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.Kxp.zQ(false);
            a.this.KdO.setHint((CharSequence) null);
            AppMethodBeat.o(32050);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPT() {
            AppMethodBeat.i(32051);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            a.this.Kxp.zQ(false);
            a.this.KdO.setHint((CharSequence) null);
            a.b(a.this, 2);
            AppMethodBeat.o(32051);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(32052);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (a.this.Koh) {
                    a.this.Koh = false;
                }
                Log.i("MicroMsg.VoiceInputPanel", "onDetected %s", strArr[0]);
                a.this.KdO.setText(strArr[0]);
                if (!a.this.KnZ && strArr[0].length() != 0) {
                    a.this.KnZ = true;
                    a.this.Koc = System.currentTimeMillis();
                    Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.this.Koc - a.this.Kob));
                }
                a.this.GvY.addAll(list);
            }
            AppMethodBeat.o(32052);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void aQ(int i2, int i3, int i4) {
            AppMethodBeat.i(32053);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(System.currentTimeMillis()));
            a.d(a.this);
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(128);
            }
            if (i2 == 12) {
                a.a(a.this, (int) R.string.hz6);
            } else {
                a.a(a.this, (int) R.string.u5);
            }
            a.this.Kxp.zQ(false);
            a.this.KdO.setHint((CharSequence) null);
            AppMethodBeat.o(32053);
        }
    };
    public boolean Koo = true;
    private AbstractC2035a Kxp;
    AudioManager audioManager;
    private String dAi = "";
    private Button han;
    private Context mContext;
    PhoneStateListener mtH = new PhoneStateListener() {
        /* class com.tencent.mm.pluginsdk.ui.websearch.a.AnonymousClass4 */

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(32046);
            super.onCallStateChanged(i2, str);
            int i3 = -1;
            if (a.this.KnI != null) {
                i3 = a.this.KnI.getCurrentState();
            }
            Log.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            VoiceInputLayout unused = a.this.KnI;
            if (i3 != 2) {
                AppMethodBeat.o(32046);
                return;
            }
            a.this.pause();
            AppMethodBeat.o(32046);
        }
    };
    private boolean xfD = false;
    private Toast xfv;
    private TelephonyManager yoi;

    /* renamed from: com.tencent.mm.pluginsdk.ui.websearch.a$a  reason: collision with other inner class name */
    public interface AbstractC2035a {
        void bez(String str);

        void gpc();

        void zQ(boolean z);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(32064);
        aVar.grB();
        AppMethodBeat.o(32064);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(32054);
        this.mContext = context;
        Log.d("MicroMsg.VoiceInputPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        View.inflate(getContext(), R.layout.cbh, this);
        this.KnJ = (ImageButton) findViewById(R.id.j_0);
        this.KnK = (Button) findViewById(R.id.j9z);
        this.han = (Button) findViewById(R.id.j_5);
        this.KnP = (TextView) findViewById(R.id.i5i);
        this.KnJ.setVisibility(0);
        this.han.setVisibility(4);
        this.KnK.setVisibility(8);
        this.KdO = (MMEditText) findViewById(R.id.j_7);
        this.KdO.setHintTextColor(getResources().getColor(R.color.a2t));
        this.KdO.setClickable(false);
        this.KnO = (VoiceInputScrollView) findViewById(R.id.j_4);
        this.KnJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.websearch.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(32043);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(a.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(32043);
            }
        });
        this.KdO.clearFocus();
        this.KdO.setFocusable(false);
        this.KdO.setClickable(false);
        this.KdO.setLongClickable(false);
        this.audioManager = (AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.dAi = String.valueOf(System.nanoTime());
        Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.dAi);
        grz();
        AppMethodBeat.o(32054);
    }

    public final void grz() {
        AppMethodBeat.i(32055);
        this.KnQ = Util.currentTicks();
        if (this.Kok == null) {
            Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.Kok = new IListener<yz>() {
                /* class com.tencent.mm.pluginsdk.ui.websearch.a.AnonymousClass3 */

                {
                    AppMethodBeat.i(161485);
                    this.__eventId = yz.class.getName().hashCode();
                    AppMethodBeat.o(161485);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(yz yzVar) {
                    AppMethodBeat.i(32045);
                    yz yzVar2 = yzVar;
                    if (!(yzVar2 instanceof yz)) {
                        Log.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        AppMethodBeat.o(32045);
                        return false;
                    } else if (yzVar2 == null || yzVar2.efi == null) {
                        Log.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        AppMethodBeat.o(32045);
                        return false;
                    } else if (!yzVar2.efi.userCode.equalsIgnoreCase(a.this.dAi)) {
                        Log.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        a.this.destroy();
                        AppMethodBeat.o(32045);
                        return false;
                    } else {
                        Log.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(yzVar2.efi.action), Integer.valueOf(yzVar2.efi.efj));
                        if (yzVar2.efi.action == 2) {
                            if (yzVar2.efi.efj == 1) {
                                a.this.Kof = true;
                            } else {
                                a.this.Kof = false;
                            }
                            a.this.KdO.setText(yzVar2.efi.result);
                            a.d(a.this);
                        } else if (yzVar2.efi.action == 3) {
                            if (a.this.Kxp != null) {
                                a.this.Kxp.gpc();
                            }
                        } else if (yzVar2.efi.action == 1 || yzVar2.efi.action == 4) {
                            if (yzVar2.efi.efj == 1) {
                                a.this.Kof = true;
                            } else {
                                a.this.Kof = false;
                            }
                            a.this.KdO.setText(yzVar2.efi.result);
                            a.d(a.this);
                            a.b(a.this, yzVar2.efi.action);
                        } else {
                            a.this.reset();
                        }
                        AppMethodBeat.o(32045);
                        return true;
                    }
                }
            };
            EventCenter.instance.addListener(this.Kok);
        }
        if (this.KnI == null) {
            this.KnI = (VoiceInputLayout) findViewById(R.id.j_8);
            this.KnI.setVoiceDetectListener(this.Kon);
            this.KnI.setLongClickLisnter(this.KdJ);
        }
        this.KnP.setVisibility(0);
        if (this.yoi == null) {
            this.yoi = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(32055);
    }

    public final void setCallback(AbstractC2035a aVar) {
        this.Kxp = aVar;
    }

    public final void pause() {
        AppMethodBeat.i(32056);
        Log.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.KnI != null) {
            this.KnI.biE();
        }
        this.KnS = 0.0f;
        this.KnT = 0.0f;
        this.KnU = false;
        this.KnV = false;
        this.xfD = false;
        this.KnW = false;
        this.Koe = false;
        this.Koo = true;
        AppMethodBeat.o(32056);
    }

    public final void reset() {
        AppMethodBeat.i(32057);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.Kof = false;
        this.GvY.clear();
        if (this.KdO != null) {
            this.KdO.setText("");
            grB();
        }
        AppMethodBeat.o(32057);
    }

    public final void destroy() {
        AppMethodBeat.i(32058);
        Log.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.Kok != null) {
            EventCenter.instance.removeListener(this.Kok);
            this.Kok = null;
        }
        if (this.KnI != null) {
            this.KnI.biE();
            this.KnI.setVoiceDetectListener(null);
            this.KnI.dQn();
            this.KnI.gpe();
            this.KnI = null;
        }
        if (!(this.yoi == null || this.mtH == null)) {
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.mtH);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.mtH = null;
        }
        this.yoi = null;
        this.mContext = null;
        AppMethodBeat.o(32058);
    }

    public final void setToUser(String str) {
        AppMethodBeat.i(32059);
        if (!Util.isNullOrNil(str)) {
            this.dAi = str;
            AppMethodBeat.o(32059);
            return;
        }
        Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        AppMethodBeat.o(32059);
    }

    public final void grB() {
        AppMethodBeat.i(32060);
        Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.KdO == null || this.KdO.getText() == null || this.KdO.getText().length() != 0) {
            this.KnJ.setVisibility(4);
            this.KnP.setVisibility(8);
        } else {
            this.han.setVisibility(4);
            this.KnJ.setVisibility(0);
            this.KnK.setVisibility(8);
            this.KnP.setVisibility(0);
        }
        bdZ();
        if (!this.Koa) {
            this.Koa = true;
            this.Kod = System.currentTimeMillis();
            Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.Kod), Long.valueOf(this.Kod - this.Koc));
        }
        AppMethodBeat.o(32060);
    }

    private void bdZ() {
        AppMethodBeat.i(32061);
        if (this.audioManager != null) {
            this.audioManager.setStreamMute(3, false);
        }
        AppMethodBeat.o(32061);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(32062);
        Log.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (aVar.Kxp != null) {
            aVar.Koe = true;
            Log.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (aVar.KdO == null || aVar.KdO.getText() == null || aVar.KdO.getText().length() <= 0) {
                if (aVar.Koe) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (aVar.Koe) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (aVar.KnQ != 0) {
                voiceInputBehavior.voiceInputTime = Util.ticksToNow(aVar.KnQ);
                aVar.KnQ = 0;
            }
            aVar.Kxp.gpc();
        }
        AppMethodBeat.o(32062);
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(32063);
        if (aVar.xfv != null) {
            aVar.xfv.cancel();
        }
        aVar.xfv = Toast.makeText(aVar.mContext, aVar.mContext.getResources().getString(i2), 0);
        aVar.xfv.setGravity(17, 0, 0);
        aVar.xfv.show();
        AppMethodBeat.o(32063);
    }

    static /* synthetic */ void b(a aVar, int i2) {
        AppMethodBeat.i(32065);
        Log.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (!(aVar.KdO == null || aVar.KdO.getText() == null)) {
            String obj = aVar.KdO.getText().toString();
            if (!((obj.trim().length() == 0 && obj.length() == 0) || aVar.Kxp == null)) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 1;
                if (aVar.Kof) {
                    voiceInputBehavior.send = 2;
                }
                if (i2 != 1 && i2 == 4) {
                    voiceInputBehavior.send = 4;
                }
                Log.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                aVar.Kxp.bez(obj);
            }
        }
        AppMethodBeat.o(32065);
    }
}
