package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.game.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yz;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.b.a.jw;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.List;

public final class n extends LinearLayout {
    private ArrayList<Integer> Gug = new ArrayList<>();
    private ArrayList<String> Guh = new ArrayList<>();
    private com.tencent.mm.modelvoiceaddr.b.b GvX;
    private List<String> GvY = new ArrayList();
    private VoiceInputLayout.a KdJ = new VoiceInputLayout.a() {
        /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass11 */

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a
        public final void dPW() {
            AppMethodBeat.i(31778);
            n.c(n.this, (int) R.string.hz7);
            AppMethodBeat.o(31778);
        }
    };
    private MMEditText KdO;
    public int Khj = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int) c.CTRL_INDEX);
    private d Kiv;
    private VoiceInputLayout KnI;
    private ImageButton KnJ;
    private Button KnK;
    private TextView KnL;
    private a KnM;
    private MMEditText KnN = null;
    private VoiceInputScrollView KnO;
    private TextView KnP;
    private long KnQ = 0;
    private boolean KnR = false;
    private float KnS = 0.0f;
    private float KnT = 0.0f;
    private boolean KnU = false;
    private boolean KnV = false;
    private boolean KnW = false;
    private int KnX = 300;
    private final String KnY = "voiceinput_downdistance_content";
    private boolean KnZ = false;
    private boolean Koa = false;
    private long Kob = 0;
    private long Koc = 0;
    private long Kod = 0;
    private boolean Koe = false;
    private boolean Kof = false;
    private final int Kog = 2;
    private boolean Koh = false;
    private String Koi = "";
    private m Koj;
    private IListener<yz> Kok;
    private int Kol = 0;
    b Kom;
    private VoiceInputLayout.b Kon = new VoiceInputLayout.b() {
        /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass3 */

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPN() {
            AppMethodBeat.i(31763);
            n.this.Kob = System.currentTimeMillis();
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(n.this.Kob));
            Log.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(n.this.Kob));
            n.this.KnZ = false;
            n.this.Koa = true;
            n.this.Koh = true;
            n.this.Koc = 0;
            n.this.Kod = 0;
            n.l(n.this);
            n.this.KnP.setVisibility(8);
            n.this.Koa = false;
            n.this.Koj.KdF = 3;
            n.this.Koj.e(n.this.KdO);
            n.grC();
            if (n.this.KdO != null) {
                if (n.this.KdO.getText() != null && n.this.KdO.getText().length() > 0) {
                    n.this.KdO.setCursorVisible(true);
                }
                n.this.KdO.requestFocus();
                Util.hideVKB(n.this.KnI);
            }
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().addFlags(128);
            }
            n.this.han.setVisibility(4);
            n.this.KnJ.setVisibility(4);
            n.this.KnK.setVisibility(8);
            n.this.KdO.setHint(n.this.getResources().getString(R.string.hz5));
            n.this.KnM.zQ(true);
            n.this.KnL.setVisibility(8);
            n.this.aiG(1);
            za zaVar = new za();
            zaVar.efk.isStart = true;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31763);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPQ() {
            AppMethodBeat.i(31764);
            n.this.KnM.zQ(false);
            n.this.KdO.setHint((CharSequence) null);
            n.this.KnL.setVisibility((n.this.Gug.size() < 2 || n.this.KdO.getText().length() > 0) ? 8 : 0);
            za zaVar = new za();
            zaVar.efk.isStart = false;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31764);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPR() {
            AppMethodBeat.i(31765);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            n.v(n.this);
            n.this.Koj.d(n.this.KdO);
            n.l(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.aiH(2);
            n.this.KnM.zQ(false);
            n.this.KdO.setHint((CharSequence) null);
            n.this.KnL.setVisibility((n.this.Gug.size() < 2 || n.this.KdO.getText().length() > 0) ? 8 : 0);
            za zaVar = new za();
            zaVar.efk.isStart = false;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31765);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPS() {
            AppMethodBeat.i(31766);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            n.this.Koj.d(n.this.KdO);
            n.l(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.aiH(3);
            n.this.KnM.zQ(false);
            n.this.KdO.setHint((CharSequence) null);
            za zaVar = new za();
            zaVar.efk.isStart = false;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31766);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void dPT() {
            AppMethodBeat.i(31767);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            n.v(n.this);
            n.this.Koj.d(n.this.KdO);
            n.l(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.aiI(1);
            n.this.KnM.zQ(false);
            n.this.KdO.setHint((CharSequence) null);
            za zaVar = new za();
            zaVar.efk.isStart = false;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31767);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void c(String[] strArr, List<String> list) {
            AppMethodBeat.i(31768);
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (n.this.Koh) {
                    n.this.Koh = false;
                    n.x(n.this);
                }
                n.this.Koj.a(n.this.KdO, strArr[0], true);
                if (n.this.KdO.getText().length() != 0) {
                    n.this.KdO.setCursorVisible(true);
                    n.this.KdO.requestFocus();
                    Util.hideVKB(n.this.KnI);
                }
                if (!n.this.KnZ && strArr[0].length() != 0) {
                    n.this.KnZ = true;
                    n.this.Koc = System.currentTimeMillis();
                    Log.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.this.Koc - n.this.Kob));
                }
                n.this.GvY.addAll(list);
            }
            AppMethodBeat.o(31768);
        }

        @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b
        public final void aQ(int i2, int i3, int i4) {
            AppMethodBeat.i(31769);
            Log.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(System.currentTimeMillis()));
            n.v(n.this);
            n.this.Koj.d(n.this.KdO);
            n.l(n.this);
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(128);
            }
            n.aiI(i2);
            if (i2 == 12) {
                n.c(n.this, (int) R.string.hz6);
            } else {
                n.c(n.this, (int) R.string.u5);
            }
            n.this.KnM.zQ(false);
            n.this.KdO.setHint((CharSequence) null);
            za zaVar = new za();
            zaVar.efk.isStart = false;
            EventCenter.instance.publish(zaVar);
            AppMethodBeat.o(31769);
        }
    };
    public boolean Koo = true;
    private String dAi = "";
    private Button han;
    private Context mContext;
    private boolean xfD = false;
    private Toast xfv;
    private TelephonyManager yoi;

    public interface a {
        void bez(String str);

        void gpc();

        void zQ(boolean z);
    }

    static /* synthetic */ void aiH(int i2) {
        AppMethodBeat.i(31801);
        aiF(i2);
        AppMethodBeat.o(31801);
    }

    static /* synthetic */ void c(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(31796);
        a(voiceInputBehavior);
        AppMethodBeat.o(31796);
    }

    static /* synthetic */ void l(n nVar) {
        AppMethodBeat.i(31798);
        nVar.grB();
        AppMethodBeat.o(31798);
    }

    public n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        AppMethodBeat.i(31780);
        this.mContext = context;
        this.KnR = z;
        this.KnN = mMEditText;
        Log.d("MicroMsg.VoiceInputPanel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        View.inflate(getContext(), R.layout.c6j, this);
        this.KnJ = (ImageButton) findViewById(R.id.j_0);
        this.KnK = (Button) findViewById(R.id.j9z);
        this.KnL = (TextView) findViewById(R.id.j_3);
        this.han = (Button) findViewById(R.id.j_5);
        this.KnP = (TextView) findViewById(R.id.i5i);
        if (this.KnR) {
            this.KnJ.setVisibility(4);
        } else {
            this.KnJ.setVisibility(0);
        }
        this.han.setVisibility(4);
        this.KnK.setVisibility(8);
        if (!this.KnR || this.KnN == null) {
            this.KdO = (MMEditText) findViewById(R.id.j_7);
            this.KdO.setHintTextColor(getResources().getColor(R.color.a2t));
            this.KdO.setClickable(true);
            this.KdO.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(31761);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (n.this.KnW) {
                        n.this.xfD = true;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(31761);
                    return true;
                }
            });
            this.KdO.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass4 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(31770);
                    boolean a2 = n.a(n.this, view, motionEvent);
                    AppMethodBeat.o(31770);
                    return a2;
                }
            });
        } else {
            this.KdO = this.KnN;
        }
        this.KnO = (VoiceInputScrollView) findViewById(R.id.j_4);
        this.KnJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(31771);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.this.grA();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31771);
            }
        });
        this.han.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(31772);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.a(n.this, 2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31772);
            }
        });
        this.KnK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(31773);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                n.this.reset();
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.clear = 1;
                n.c(voiceInputBehavior);
                n.this.aiG(4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31773);
            }
        });
        this.KnL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(31775);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final f.a aVar = new f.a(n.this.getContext());
                aVar.aC(n.this.getContext().getString(R.string.hz0)).a(n.this.Guh, new RadioGroup.OnCheckedChangeListener() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass8.AnonymousClass1 */

                    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                        AppMethodBeat.i(31774);
                        n.this.Kol = i2;
                        n.this.KnL.setText((CharSequence) n.this.Guh.get(n.this.Kol));
                        if (n.this.KnI != null) {
                            n.this.KnI.setLangType(((Integer) n.this.Gug.get(n.this.Kol)).intValue());
                        }
                        if (aVar.kdo != null) {
                            aVar.kdo.dismiss();
                        }
                        n.this.aiG(2);
                        AppMethodBeat.o(31774);
                    }
                }, n.this.Kol).Dq(true);
                aVar.a(new f.c() {
                    /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass8.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                    }
                });
                aVar.show();
                n.this.aiG(3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31775);
            }
        });
        if ((this.KdO.getText() != null && this.KdO.getText().length() > 0) || (this.KdO.getHint() != null && this.KdO.getHint().length() > 0)) {
            this.KnL.setVisibility(8);
        }
        this.KdO.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass9 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(31776);
                if (n.this.Gug.size() < 2 || ((n.this.KdO.getText() != null && n.this.KdO.getText().length() > 0) || (n.this.KdO.getHint() != null && n.this.KdO.getHint().length() > 0))) {
                    n.this.KnL.setVisibility(8);
                    AppMethodBeat.o(31776);
                    return;
                }
                n.this.KnL.setVisibility(0);
                AppMethodBeat.o(31776);
            }
        });
        this.KnO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass10 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(31777);
                boolean a2 = n.a(n.this, view, motionEvent);
                AppMethodBeat.o(31777);
                return a2;
            }
        });
        this.Koj = new m(this.mContext);
        this.dAi = "MicroMsg.VoiceInputPanel" + String.valueOf(System.nanoTime());
        Log.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.dAi);
        grz();
        int i2 = h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
        if (LocaleUtil.isChineseAppLang()) {
            this.Guh.add(getContext().getString(R.string.hz2));
            this.Gug.add(Integer.valueOf(g.jwq));
            if ((g.jwr & i2) != 0) {
                this.Guh.add(getContext().getString(R.string.hz1));
                this.Gug.add(Integer.valueOf(g.jwr));
            }
            if ((g.jws & i2) != 0) {
                this.Guh.add(getContext().getString(R.string.hz3));
                this.Gug.add(Integer.valueOf(g.jws));
            }
            if ((i2 & g.jwt) != 0) {
                this.Guh.add(getContext().getString(R.string.hz4));
                this.Gug.add(Integer.valueOf(g.jwt));
            }
        } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH)) {
            this.Guh.add(getContext().getString(R.string.hz3));
            this.Gug.add(Integer.valueOf(g.jws));
            this.Guh.add(getContext().getString(R.string.hz2));
            this.Gug.add(Integer.valueOf(g.jwq));
            if ((i2 & g.jwr) != 0) {
                this.Guh.add(getContext().getString(R.string.hz1));
                this.Gug.add(Integer.valueOf(g.jwr));
            }
        }
        this.Kol = 0;
        this.KnL.setText(this.Guh.get(this.Kol));
        this.KnI.setLangType(this.Gug.get(this.Kol).intValue());
        if (this.Gug.size() < 2) {
            this.KnL.setVisibility(8);
        }
        AppMethodBeat.o(31780);
    }

    public final void grz() {
        AppMethodBeat.i(31781);
        this.KnQ = Util.currentTicks();
        if (this.Kok == null) {
            Log.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.Kok = new IListener<yz>() {
                /* class com.tencent.mm.pluginsdk.ui.chat.n.AnonymousClass2 */

                {
                    AppMethodBeat.i(161483);
                    this.__eventId = yz.class.getName().hashCode();
                    AppMethodBeat.o(161483);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(yz yzVar) {
                    AppMethodBeat.i(31762);
                    yz yzVar2 = yzVar;
                    if (!(yzVar2 instanceof yz)) {
                        Log.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        AppMethodBeat.o(31762);
                        return false;
                    } else if (yzVar2 == null || yzVar2.efi == null) {
                        Log.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        AppMethodBeat.o(31762);
                        return false;
                    } else if (n.this.KnR) {
                        Log.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
                        AppMethodBeat.o(31762);
                        return false;
                    } else if (!yzVar2.efi.userCode.equalsIgnoreCase(n.this.dAi)) {
                        Log.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        n.this.destroy();
                        AppMethodBeat.o(31762);
                        return false;
                    } else {
                        n.this.setToUser(n.this.dAi);
                        Log.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(yzVar2.efi.action), Integer.valueOf(yzVar2.efi.efj));
                        if (yzVar2.efi.action == 2) {
                            if (yzVar2.efi.efj == 1) {
                                n.this.Kof = true;
                            } else {
                                n.this.Kof = false;
                            }
                            String str = yzVar2.efi.result;
                            n.this.Koj.e(n.this.KdO);
                            n.this.Koj.a(n.this.KdO, str, false);
                            n.this.Koj.d(n.this.KdO);
                            n.this.Koj.e(n.this.KdO);
                            n.l(n.this);
                            n.this.KnO.fullScroll(130);
                        } else if (yzVar2.efi.action == 3) {
                            if (n.this.KnM != null) {
                                n.this.KnM.gpc();
                            }
                        } else if (yzVar2.efi.action == 1 || yzVar2.efi.action == 4) {
                            if (yzVar2.efi.efj == 1) {
                                n.this.Kof = true;
                            } else {
                                n.this.Kof = false;
                            }
                            n.this.Koj.a(n.this.KdO, yzVar2.efi.result, false);
                            n.this.Koj.d(n.this.KdO);
                            n.this.Koj.e(n.this.KdO);
                            n.l(n.this);
                            n.this.KnO.fullScroll(130);
                            n.a(n.this, yzVar2.efi.action);
                        } else {
                            n.this.reset();
                        }
                        AppMethodBeat.o(31762);
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
            this.KnI.setFromFullScreen(this.KnR);
        }
        this.KnP.setVisibility(0);
        if (this.GvX == null) {
            this.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
        }
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        if (defaultPreference != null) {
            String string = defaultPreference.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                Log.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", Integer.valueOf(string.length()));
                this.Koj.e(this.KdO);
                this.Koj.a(this.KdO, string, false);
                this.Koj.d(this.KdO);
                this.Koj.e(this.KdO);
                grB();
                this.KnO.fullScroll(130);
                defaultPreference.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.yoi = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (this.yoi != null) {
            if (this.Kom == null) {
                this.Kom = new b(this.KnI);
            }
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.Kom);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "initAllListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(31781);
    }

    public final void setFullScreenData(String str) {
        AppMethodBeat.i(31782);
        if (str != null) {
            this.Koi = str;
        }
        grB();
        AppMethodBeat.o(31782);
    }

    /* access modifiers changed from: package-private */
    public static class b extends PhoneStateListener {
        VoiceInputLayout KnI;

        public b(VoiceInputLayout voiceInputLayout) {
            this.KnI = voiceInputLayout;
        }

        public final void onCallStateChanged(int i2, String str) {
            AppMethodBeat.i(31779);
            super.onCallStateChanged(i2, str);
            int i3 = -1;
            if (this.KnI != null) {
                i3 = this.KnI.getCurrentState();
                this.KnI.biE();
            }
            Log.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i3 != 2) {
                AppMethodBeat.o(31779);
            } else {
                AppMethodBeat.o(31779);
            }
        }
    }

    public final void setCallback(a aVar) {
        this.KnM = aVar;
    }

    public final void pause() {
        AppMethodBeat.i(31783);
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
        AppMethodBeat.o(31783);
    }

    public final void reset() {
        AppMethodBeat.i(31784);
        Log.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.Kof = false;
        this.GvY.clear();
        if (this.KdO != null) {
            if (this.Koj != null) {
                this.Koj.e(this.KdO);
                this.Koj.a(this.KdO, "", false);
                this.Koj.d(this.KdO);
                this.Koj.e(this.KdO);
            }
            grB();
        }
        AppMethodBeat.o(31784);
    }

    public final void destroy() {
        AppMethodBeat.i(31785);
        Log.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.Kok != null) {
            EventCenter.instance.removeListener(this.Kok);
            this.Kok = null;
        }
        if (this.KnI != null) {
            this.KnI.setVoiceDetectListener(null);
            this.KnI = null;
        }
        if (this.GvX != null) {
            this.GvX = null;
        }
        if (!(this.yoi == null || this.Kom == null)) {
            TelephonyManager telephonyManager = this.yoi;
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(this.Kom);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "destroy", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.Kom.KnI = null;
            this.Kom = null;
        }
        this.yoi = null;
        this.KnN = null;
        if (!this.dAi.startsWith("MicroMsg.VoiceInputPanel")) {
            this.Koj.gH(this.dAi, this.Gug.get(this.Kol).intValue());
        }
        VoiceInputLayoutImpl voiceInputLayoutImpl = (VoiceInputLayoutImpl) findViewById(R.id.j_8);
        if (voiceInputLayoutImpl != null) {
            Log.i("MicroMsg.VoiceInputPanel", "voiceInputLayout do stop!");
            voiceInputLayoutImpl.dQn();
            voiceInputLayoutImpl.gpe();
        }
        AppMethodBeat.o(31785);
    }

    /* access modifiers changed from: package-private */
    public final void grA() {
        AppMethodBeat.i(31786);
        Log.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.KnM != null) {
            this.Koe = true;
            Log.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.KdO == null || this.KdO.getText() == null || this.KdO.getText().length() <= 0) {
                if (this.Koe) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.Koe) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.KnQ != 0) {
                voiceInputBehavior.voiceInputTime = Util.ticksToNow(this.KnQ);
                this.KnQ = 0;
            }
            a(voiceInputBehavior);
            this.KnM.gpc();
        }
        AppMethodBeat.o(31786);
    }

    public final void setPortHeightPX(int i2) {
        AppMethodBeat.i(31787);
        Log.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.Khj), Integer.valueOf(i2));
        if (this.Khj != i2) {
            this.Khj = i2;
            this.Koo = true;
        }
        AppMethodBeat.o(31787);
    }

    public final void setToUser(String str) {
        int i2 = 0;
        AppMethodBeat.i(31788);
        if (!Util.isNullOrNil(str)) {
            this.dAi = str;
            this.Kol = 0;
            int beA = this.Koj.beA(str);
            while (true) {
                if (i2 >= this.Gug.size()) {
                    break;
                } else if (beA == this.Gug.get(i2).intValue()) {
                    this.Kol = i2;
                    this.KnL.setText(this.Guh.get(this.Kol));
                    this.KnI.setLangType(this.Gug.get(this.Kol).intValue());
                    if (this.Gug.size() < 2) {
                        this.KnL.setVisibility(8);
                        AppMethodBeat.o(31788);
                        return;
                    }
                } else {
                    i2++;
                }
            }
            AppMethodBeat.o(31788);
            return;
        }
        Log.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        AppMethodBeat.o(31788);
    }

    public final void grB() {
        AppMethodBeat.i(31789);
        Log.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.KdO == null || this.KdO.getText() == null || this.KdO.getText().length() != 0) {
            if (this.KdO != null) {
                this.KdO.setCursorVisible(true);
            }
            this.han.setVisibility(0);
            if (!this.KnR) {
                this.KnJ.setVisibility(8);
                this.KnK.setVisibility(0);
            }
            this.KnP.setVisibility(8);
        } else {
            this.KdO.setSelection(0);
            this.KdO.setCursorVisible(false);
            this.han.setVisibility(4);
            if (!this.KnR) {
                this.KnJ.setVisibility(0);
            }
            this.KnK.setVisibility(8);
            this.KnP.setVisibility(0);
        }
        if (this.KnR) {
            if (this.KnN == null || this.KnN.getText() == null || this.KnN.getText().length() != 0) {
                this.han.setVisibility(0);
            } else {
                this.han.setVisibility(4);
            }
        }
        if (this.KdO != null) {
            this.KdO.clearFocus();
        }
        bdZ();
        if (!this.Koa) {
            this.Koa = true;
            this.Kod = System.currentTimeMillis();
            Log.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.Kod), Long.valueOf(this.Kod - this.Koc));
        }
        AppMethodBeat.o(31789);
    }

    private static void bdZ() {
        AppMethodBeat.i(31790);
        Log.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        com.tencent.mm.plugin.audio.c.a.bdZ();
        AppMethodBeat.o(31790);
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        AppMethodBeat.i(31791);
        Log.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        log_13905 log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.h.INSTANCE.c(13905, log_13905);
        AppMethodBeat.o(31791);
    }

    private static void aiF(int i2) {
        AppMethodBeat.i(31792);
        Log.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i2));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(455, (long) i2, 1, false);
        AppMethodBeat.o(31792);
    }

    public final void aiG(int i2) {
        AppMethodBeat.i(31793);
        Log.i("MicroMsg.VoiceInputPanel", "action:%d, applang:%s, voiceLang:%s", Integer.valueOf(i2), LocaleUtil.getApplicationLanguage(), this.Gug.get(this.Kol).toString());
        jw jwVar = new jw();
        jwVar.eSN = (long) i2;
        jwVar.eSO = jwVar.x("WechatLanguage", LocaleUtil.getApplicationLanguage(), true);
        jwVar.eSP = jwVar.x("InputLanguage", this.Gug.get(this.Kol).toString(), true);
        jwVar.bfK();
        AppMethodBeat.o(31793);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        float f2;
        SharedPreferences defaultPreference;
        boolean z;
        AppMethodBeat.i(31794);
        if (motionEvent.getAction() == 0) {
            if (nVar.KnO.getScrollY() <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                nVar.KnV = true;
                nVar.KnS = motionEvent.getRawY();
            }
            nVar.KnW = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.KnU = true;
        } else if (motionEvent.getAction() == 1) {
            if (!nVar.KnU || !nVar.KnV) {
                f2 = 0.0f;
            } else {
                nVar.KnT = motionEvent.getRawY();
                f2 = nVar.KnT - nVar.KnS;
            }
            nVar.KnW = false;
            nVar.KnU = false;
            nVar.KnV = false;
            nVar.KnT = 0.0f;
            nVar.KnS = 0.0f;
            if (f2 > ((float) nVar.KnX)) {
                if (!(nVar.KdO == null || nVar.KdO.getText() == null || nVar.KdO.getText().length() <= 0 || (defaultPreference = MMApplicationContext.getDefaultPreference()) == null)) {
                    defaultPreference.edit().putString("voiceinput_downdistance_content", nVar.KdO.getText().toString()).apply();
                    Log.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                }
                nVar.grA();
            } else if (nVar.xfD) {
                nVar.xfD = false;
            } else if ((view instanceof MMEditText) && nVar.KdO != null && nVar.KdO.getText() != null && nVar.KdO.getText().length() > 0) {
                Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = ((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop();
                int scrollX = x + mMEditText.getScrollX();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y + mMEditText.getScrollY()), (float) scrollX);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    int offsetForPosition = ((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    Log.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(offsetForPosition));
                    if (nVar.KnI != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = nVar.KnI.getCurrentState();
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(nVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForPosition);
                    intent.putExtra("userCode", nVar.dAi);
                    if (!(nVar.KdO == null || nVar.KdO.getText() == null)) {
                        intent.putExtra("text", nVar.KdO.getText().toString());
                        if (nVar.Koj != null) {
                            nVar.Koj.e(nVar.KdO);
                        }
                    }
                    if (nVar.Koi.equalsIgnoreCase("。") || nVar.Koi.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", nVar.Koi);
                    }
                    nVar.Koj.gH(nVar.dAi, nVar.Gug.get(nVar.Kol).intValue());
                    Context context = nVar.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "startVoiceInputUIActivity", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel", "startVoiceInputUIActivity", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    if (nVar.KnI != null) {
                        Util.hideVKB(nVar.KnI);
                        nVar.KnI.biE();
                    }
                }
            }
            if (view instanceof MMEditText) {
                AppMethodBeat.o(31794);
                return true;
            }
            AppMethodBeat.o(31794);
            return false;
        }
        if (view instanceof MMEditText) {
            AppMethodBeat.o(31794);
            return true;
        }
        AppMethodBeat.o(31794);
        return false;
    }

    static /* synthetic */ void a(n nVar, int i2) {
        int i3;
        AppMethodBeat.i(31795);
        Log.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (nVar.KdO == null || nVar.KdO.getText() == null) {
            if (nVar.Kiv == null || !nVar.Kiv.isShowing()) {
                nVar.Kiv = com.tencent.mm.ui.base.h.n(nVar.getContext(), R.string.ay6, R.string.zb);
            }
            AppMethodBeat.o(31795);
            return;
        }
        String obj = nVar.KdO.getText().toString();
        if (obj.trim().length() == 0 && obj.length() == 0) {
            if (nVar.Kiv == null || !nVar.Kiv.isShowing()) {
                nVar.Kiv = com.tencent.mm.ui.base.h.n(nVar.getContext(), R.string.ay6, R.string.zb);
                AppMethodBeat.o(31795);
                return;
            }
        } else if (nVar.KnM != null) {
            if (!nVar.KnR) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 1;
                if (nVar.Kof) {
                    voiceInputBehavior.send = 2;
                }
                if (i2 != 1) {
                    if (i2 == 4) {
                        voiceInputBehavior.send = 4;
                    }
                    a(voiceInputBehavior);
                }
                if (i2 == 1 || i2 == 2 || i2 == 4) {
                    Log.i("MicroMsg.VoiceInputPanel", "cgiReport size = %s", Integer.valueOf(nVar.GvY.size()));
                    if (nVar.GvX == null) {
                        nVar.GvX = new com.tencent.mm.modelvoiceaddr.b.b();
                    }
                    com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100235");
                    if (Fu.isValid()) {
                        i3 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
                    } else {
                        i3 = 0;
                    }
                    Log.i("MicroMsg.VoiceInputPanel", "cgiReport: abTestFlag = [%s]", Integer.valueOf(i3));
                    com.tencent.mm.kernel.g.aAk().postToWorker(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e7: INVOKE  
                          (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x00de: INVOKE  (r3v6 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                          (wrap: com.tencent.mm.modelvoiceaddr.b.b$1 : 0x00e4: CONSTRUCTOR  (r5v4 com.tencent.mm.modelvoiceaddr.b.b$1) = 
                          (wrap: com.tencent.mm.modelvoiceaddr.b.b : 0x00d1: IGET  (r1v3 com.tencent.mm.modelvoiceaddr.b.b) = (r10v0 'nVar' com.tencent.mm.pluginsdk.ui.chat.n) com.tencent.mm.pluginsdk.ui.chat.n.GvX com.tencent.mm.modelvoiceaddr.b.b)
                          (wrap: java.util.ArrayList : 0x00db: CONSTRUCTOR  (r4v3 java.util.ArrayList) = 
                          (wrap: java.util.List<java.lang.String> : 0x00d3: IGET  (r3v5 java.util.List<java.lang.String>) = (r10v0 'nVar' com.tencent.mm.pluginsdk.ui.chat.n) com.tencent.mm.pluginsdk.ui.chat.n.GvY java.util.List)
                         call: java.util.ArrayList.<init>(java.util.Collection):void type: CONSTRUCTOR)
                          (r2v2 'obj' java.lang.String)
                          (wrap: java.lang.String : 0x00d5: INVOKE  (r0v29 java.lang.String) = (r0v28 'i3' int) type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
                         call: com.tencent.mm.modelvoiceaddr.b.b.1.<init>(com.tencent.mm.modelvoiceaddr.b.b, java.util.List, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.pluginsdk.ui.chat.n.a(com.tencent.mm.pluginsdk.ui.chat.n, int):void, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e4: CONSTRUCTOR  (r5v4 com.tencent.mm.modelvoiceaddr.b.b$1) = 
                          (wrap: com.tencent.mm.modelvoiceaddr.b.b : 0x00d1: IGET  (r1v3 com.tencent.mm.modelvoiceaddr.b.b) = (r10v0 'nVar' com.tencent.mm.pluginsdk.ui.chat.n) com.tencent.mm.pluginsdk.ui.chat.n.GvX com.tencent.mm.modelvoiceaddr.b.b)
                          (wrap: java.util.ArrayList : 0x00db: CONSTRUCTOR  (r4v3 java.util.ArrayList) = 
                          (wrap: java.util.List<java.lang.String> : 0x00d3: IGET  (r3v5 java.util.List<java.lang.String>) = (r10v0 'nVar' com.tencent.mm.pluginsdk.ui.chat.n) com.tencent.mm.pluginsdk.ui.chat.n.GvY java.util.List)
                         call: java.util.ArrayList.<init>(java.util.Collection):void type: CONSTRUCTOR)
                          (r2v2 'obj' java.lang.String)
                          (wrap: java.lang.String : 0x00d5: INVOKE  (r0v29 java.lang.String) = (r0v28 'i3' int) type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
                         call: com.tencent.mm.modelvoiceaddr.b.b.1.<init>(com.tencent.mm.modelvoiceaddr.b.b, java.util.List, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.pluginsdk.ui.chat.n.a(com.tencent.mm.pluginsdk.ui.chat.n, int):void, file: classes9.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 35 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.modelvoiceaddr.b.b, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 41 more
                        */
                    /*
                    // Method dump skipped, instructions count: 312
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.n.a(com.tencent.mm.pluginsdk.ui.chat.n, int):void");
                }

                static /* synthetic */ void c(n nVar, int i2) {
                    AppMethodBeat.i(31797);
                    if (nVar.xfv != null) {
                        nVar.xfv.cancel();
                    }
                    nVar.xfv = Toast.makeText(nVar.mContext, nVar.mContext.getResources().getString(i2), 0);
                    nVar.xfv.setGravity(17, 0, 0);
                    nVar.xfv.show();
                    AppMethodBeat.o(31797);
                }

                static /* synthetic */ void grC() {
                    AppMethodBeat.i(31799);
                    Log.i("MicroMsg.VoiceInputPanel", "pauseMusic");
                    com.tencent.mm.plugin.audio.c.a.bdY();
                    AppMethodBeat.o(31799);
                }

                static /* synthetic */ void v(n nVar) {
                    AppMethodBeat.i(31800);
                    if (!(nVar.KdO == null || nVar.KdO.getText() == null)) {
                        String obj = nVar.KdO.getText().toString();
                        if (obj.length() > 0 && (!nVar.KnR || nVar.KdO.getSelectionStart() >= obj.length())) {
                            nVar.Koi = obj.substring(obj.length() - 1, obj.length());
                            Log.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", Util.secPrint(obj), Integer.valueOf(obj.length()), nVar.Koi);
                            if (nVar.Koi.equalsIgnoreCase("。") || nVar.Koi.equalsIgnoreCase(".")) {
                                nVar.KdO.setText(obj.substring(0, obj.length() - 1));
                            }
                        }
                    }
                    AppMethodBeat.o(31800);
                }

                static /* synthetic */ void aiI(int i2) {
                    AppMethodBeat.i(31802);
                    VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                    voiceInputBehavior.fail = i2;
                    a(voiceInputBehavior);
                    aiF(i2);
                    AppMethodBeat.o(31802);
                }

                static /* synthetic */ void x(n nVar) {
                    AppMethodBeat.i(31803);
                    if (!(nVar.KdO == null || nVar.KdO.getText() == null || nVar.KdO.getText().length() <= 0)) {
                        if (nVar.Koi.equalsIgnoreCase("。") || nVar.Koi.equalsIgnoreCase(".")) {
                            if (!nVar.KnR || nVar.KdO.getSelectionStart() >= nVar.KdO.getText().length()) {
                                nVar.Koj.a(nVar.KdO, nVar.Koi, true);
                                nVar.Koj.e(nVar.KdO);
                            }
                            nVar.Koi = "";
                        }
                        String obj = nVar.KdO.getText().toString();
                        Log.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", Util.secPrint(obj), Integer.valueOf(obj.length()));
                    }
                    AppMethodBeat.o(31803);
                }
            }
