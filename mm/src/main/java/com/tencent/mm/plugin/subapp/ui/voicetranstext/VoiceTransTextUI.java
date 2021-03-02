package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.no;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storage.cv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class VoiceTransTextUI extends MMActivity implements View.OnClickListener, i {
    private long BAN = 0;
    private boolean CJo = false;
    private int Dn;
    private a FIA;
    private c FIB;
    private b FIC;
    private volatile boolean FIF = false;
    private boolean FIG = false;
    private MTimerHandler FIH;
    private cu FIt;
    private View FNM = null;
    private View FNN = null;
    private LinearLayout FNO = null;
    private TextView FNP = null;
    private Button FNQ = null;
    private int FNR = 6;
    private boolean FNS = false;
    private r FNT;
    private IListener FNU;
    private boolean FNV = false;
    private int FNW;
    private View.OnTouchListener FNX;
    private View.OnClickListener FNY = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(29281);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            VoiceTransTextUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29281);
        }
    };
    private View.OnLongClickListener FNZ = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass2 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(29283);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            h.a(VoiceTransTextUI.this, "", new String[]{VoiceTransTextUI.this.getString(R.string.t_)}, "", new h.d() {
                /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass2.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(29282);
                    if (i2 == 0 && VoiceTransTextUI.this.FNP != null) {
                        ClipboardHelper.setText(VoiceTransTextUI.this.FNP.getText());
                    }
                    AppMethodBeat.o(29282);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(29283);
            return false;
        }
    };
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long gof;
    private View kHq = null;
    private ScrollView lTw = null;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass6 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29288);
            int i2 = message.what;
            if (i2 == 1) {
                VoiceTransTextUI.b(VoiceTransTextUI.this, true);
                AppMethodBeat.o(29288);
                return;
            }
            if (i2 == 2) {
                VoiceTransTextUI.b(VoiceTransTextUI.this, false);
            }
            AppMethodBeat.o(29288);
        }
    };
    private int mTouchSlop;
    private int nrL;
    private ca qnv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoiceTransTextUI() {
        AppMethodBeat.i(29298);
        AppMethodBeat.o(29298);
    }

    static /* synthetic */ void a(VoiceTransTextUI voiceTransTextUI, a aVar) {
        AppMethodBeat.i(232120);
        voiceTransTextUI.a(aVar);
        AppMethodBeat.o(232120);
    }

    static /* synthetic */ void b(VoiceTransTextUI voiceTransTextUI, boolean z) {
        AppMethodBeat.i(232121);
        voiceTransTextUI.wg(z);
        AppMethodBeat.o(232121);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        CHECK,
        UPLOAD,
        UPLOAD_MORE,
        GET;

        public static a valueOf(String str) {
            AppMethodBeat.i(29293);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(29293);
            return aVar;
        }

        static {
            AppMethodBeat.i(29294);
            AppMethodBeat.o(29294);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        cu cuVar = null;
        AppMethodBeat.i(29299);
        super.onCreate(bundle);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.kHq = findViewById(R.id.jad);
        this.FNM = findViewById(R.id.ja5);
        this.FNN = findViewById(R.id.jaa);
        this.FNP = (TextView) findViewById(R.id.ja9);
        this.FNQ = (Button) findViewById(R.id.ja7);
        this.FNO = (LinearLayout) findViewById(R.id.ja_);
        this.lTw = (ScrollView) findViewById(R.id.dc2);
        this.FNX = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(29284);
                switch (motionEvent.getAction()) {
                    case 0:
                        VoiceTransTextUI.b(VoiceTransTextUI.this);
                        VoiceTransTextUI.this.nrL = view.getScrollY();
                        VoiceTransTextUI.this.Dn = VoiceTransTextUI.this.nrL;
                        VoiceTransTextUI.this.mHandler.removeMessages(0);
                        if (VoiceTransTextUI.this.CJo) {
                            VoiceTransTextUI.this.CJo = false;
                            VoiceTransTextUI.this.FNV = true;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                    case 4:
                        if (Math.abs(VoiceTransTextUI.this.Dn - view.getScrollY()) > VoiceTransTextUI.this.mTouchSlop) {
                            VoiceTransTextUI.this.mHandler.sendMessage(VoiceTransTextUI.this.mHandler.obtainMessage(0, view));
                        }
                        if (VoiceTransTextUI.i(VoiceTransTextUI.this) < 800 && Math.abs(VoiceTransTextUI.this.Dn - view.getScrollY()) <= VoiceTransTextUI.this.mTouchSlop && !VoiceTransTextUI.this.FNV) {
                            VoiceTransTextUI.this.mHandler.removeMessages(0);
                            VoiceTransTextUI.k(VoiceTransTextUI.this);
                            VoiceTransTextUI.this.finish();
                        }
                        VoiceTransTextUI.this.FNV = false;
                        break;
                }
                AppMethodBeat.o(29284);
                return false;
            }
        };
        this.FNP.setOnLongClickListener(this.FNZ);
        this.FNP.setOnClickListener(this.FNY);
        this.gof = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.gof < 0) {
            z = false;
        } else {
            Log.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.gof));
            cv bic = o.bic();
            long j2 = this.gof;
            if (j2 >= 0) {
                cu cuVar2 = new cu();
                Cursor query = bic.db.query("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
                if (query.moveToFirst()) {
                    cuVar2.convertFrom(query);
                }
                query.close();
                cuVar = cuVar2;
            }
            this.FIt = cuVar;
            if (this.FIt == null || Util.isNullOrNil(this.FIt.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (Util.isNullOrNil(string)) {
                    z = false;
                } else {
                    this.FNT = o.bib().Rr(string);
                    if (this.FNT != null) {
                        Log.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        z = true;
                    } else {
                        bg.aVF();
                        this.qnv = c.aSQ().Hb(this.gof);
                        if (this.qnv != null) {
                            Log.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
            } else {
                Log.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                z = true;
            }
        }
        if (!z) {
            Log.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            AppMethodBeat.o(29299);
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
        AppMethodBeat.o(29299);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c6y;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(29300);
        setMMTitle(R.string.i0k);
        this.FNQ.setOnClickListener(this);
        if (this.FIt == null || Util.isNullOrNil(this.FIt.field_content)) {
            z = false;
        } else {
            a(b.done, this.FIt.field_content);
            if (!(this.lTw == null || this.FNO == null)) {
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(29290);
                        VoiceTransTextUI.this.lTw.setPadding(0, 0, 0, 0);
                        VoiceTransTextUI.this.FNO.setGravity(17);
                        AppMethodBeat.o(29290);
                    }
                }, 5);
            }
            z = true;
        }
        if (z) {
            AppMethodBeat.o(29300);
            return;
        }
        a(b.loading, (String) null);
        a(a.CHECK);
        AppMethodBeat.o(29300);
    }

    private int ftx() {
        int i2 = -1;
        AppMethodBeat.i(179739);
        com.tencent.mm.modelvoice.b bVar = null;
        try {
            if (this.FNT != null) {
                bVar = s.Rf(this.FNT.fileName);
            } else if (this.qnv != null) {
                bVar = s.Rf(this.qnv.field_imgPath);
            } else {
                Log.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
            if (bVar != null) {
                i2 = bVar.getFormat();
            }
            if (bVar != null) {
                try {
                    bVar.bhP();
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(179739);
        } catch (Throwable th2) {
        }
        return i2;
        AppMethodBeat.o(179739);
        return i2;
    }

    private void a(a aVar) {
        AppMethodBeat.i(29301);
        fty();
        switch (aVar) {
            case CHECK:
                Log.i("MicroMsg.VoiceTransTextUI", "net check");
                if (ajM() > 0) {
                    Log.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(ajM()));
                    this.FIA = new a(ftz(), bcq(), ftx(), ajM(), getFileName());
                } else {
                    Log.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(ajM()));
                    this.FIA = new a(ftz(), bcq(), getFileName());
                }
                bg.azz().a(this.FIA, 0);
                bg.azz().a(this.FIA.getType(), this);
                if (this.FNU == null) {
                    ftA();
                    AppMethodBeat.o(29301);
                    return;
                }
                break;
            case UPLOAD:
                Log.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.FIA == null) {
                    Log.e("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    AppMethodBeat.o(29301);
                    return;
                } else if (ftx() == -1) {
                    Log.e("MicroMsg.VoiceTransTextUI", "can't get format!");
                    AppMethodBeat.o(29301);
                    return;
                } else {
                    this.FIB = new c(ftz(), this.FIA.FNI, ftx(), getFileName());
                    bg.azz().a(this.FIB, 0);
                    bg.azz().a(this.FIB.getType(), this);
                    AppMethodBeat.o(29301);
                    return;
                }
            case UPLOAD_MORE:
                Log.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.FIB == null) {
                    Log.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    AppMethodBeat.o(29301);
                    return;
                }
                this.FIB = new c(this.FIB);
                bg.azz().a(this.FIB, 0);
                bg.azz().a(this.FIB.getType(), this);
                AppMethodBeat.o(29301);
                return;
            case GET:
                this.FNS = false;
                if (!this.FIF) {
                    Log.i("MicroMsg.VoiceTransTextUI", "net get");
                    if (this.FIA != null) {
                        this.FIF = true;
                        this.FIC = new b(ftz());
                        bg.azz().a(this.FIC, 0);
                        bg.azz().a(this.FIC.getType(), this);
                        break;
                    } else {
                        Log.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                        AppMethodBeat.o(29301);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    AppMethodBeat.o(29301);
                    return;
                }
        }
        AppMethodBeat.o(29301);
    }

    /* access modifiers changed from: package-private */
    public enum b {
        done,
        loading,
        fail;

        public static b valueOf(String str) {
            AppMethodBeat.i(29296);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(29296);
            return bVar;
        }

        static {
            AppMethodBeat.i(29297);
            AppMethodBeat.o(29297);
        }
    }

    private void a(b bVar, String str) {
        AppMethodBeat.i(29302);
        while (true) {
            switch (bVar) {
                case done:
                    if (!Util.isNullOrNil(str)) {
                        this.FNO.setVisibility(0);
                        this.FNM.setVisibility(8);
                        this.FNQ.setVisibility(4);
                        this.FNN.setVisibility(8);
                        this.FNP.setText(str);
                        wg(true);
                        break;
                    } else {
                        bVar = b.fail;
                        str = null;
                    }
                case loading:
                    this.FNO.setVisibility(0);
                    this.FNM.setVisibility(0);
                    this.FNQ.setVisibility(0);
                    if (str != null) {
                        this.FNP.setText(str);
                        wg(false);
                        break;
                    }
                    break;
                case fail:
                    this.FNO.setVisibility(8);
                    this.FNM.setVisibility(8);
                    this.FNQ.setHeight(0);
                    this.FNQ.setVisibility(8);
                    this.FNN.setVisibility(0);
                    break;
            }
        }
        if (bVar == b.done || bVar == b.fail) {
            this.lTw.setOnTouchListener(this.FNX);
            this.kHq.setOnClickListener(this.FNY);
            AppMethodBeat.o(29302);
            return;
        }
        this.lTw.setOnTouchListener(null);
        this.kHq.setOnClickListener(null);
        AppMethodBeat.o(29302);
    }

    private void fty() {
        AppMethodBeat.i(29303);
        Log.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.FIA != null) {
            bg.azz().a(this.FIA);
            bg.azz().b(this.FIA.getType(), this);
        }
        if (this.FIB != null) {
            bg.azz().a(this.FIB);
            bg.azz().b(this.FIB.getType(), this);
        }
        if (this.FIC != null) {
            bg.azz().a(this.FIC);
            bg.azz().b(this.FIC.getType(), this);
        }
        AppMethodBeat.o(29303);
    }

    private String ftz() {
        AppMethodBeat.i(29304);
        if (this.FNT != null) {
            String str = this.FNT.clientId;
            AppMethodBeat.o(29304);
            return str;
        }
        String str2 = this.qnv.field_talker + this.qnv.field_msgId + "T" + this.qnv.field_createTime;
        AppMethodBeat.o(29304);
        return str2;
    }

    private cu aSJ(String str) {
        AppMethodBeat.i(29305);
        cu cuVar = new cu();
        cuVar.field_msgId = this.gof;
        cuVar.bkY(ftz());
        cuVar.field_content = str;
        AppMethodBeat.o(29305);
        return cuVar;
    }

    private int bcq() {
        AppMethodBeat.i(29306);
        if (this.FNT != null) {
            int i2 = this.FNT.iKP;
            AppMethodBeat.o(29306);
            return i2;
        }
        int Qy = q.Qy(this.qnv.field_imgPath);
        AppMethodBeat.o(29306);
        return Qy;
    }

    private long ajM() {
        if (this.FNT == null) {
            return -1;
        }
        return this.FNT.dTS;
    }

    private String getFileName() {
        if (this.FNT != null) {
            return this.FNT.fileName;
        }
        return this.qnv.field_imgPath;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2 = null;
        AppMethodBeat.i(29308);
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 546:
                    if (this.FIA.mState == a.FNG) {
                        Log.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.FIA.ftu()) {
                            str2 = this.FIA.FNH.NpE;
                        }
                        aSS(str2);
                        AppMethodBeat.o(29308);
                        return;
                    } else if (this.FIA.mState == a.FNF) {
                        if (this.FIA.FNH != null && Util.isNullOrNil(this.FIA.FNH.NpE)) {
                            a(b.loading, this.FIA.FNH.NpE);
                        }
                        Log.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        a(a.GET);
                        AppMethodBeat.o(29308);
                        return;
                    } else if (this.FIA.mState == a.FNE) {
                        Log.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        a(a.UPLOAD);
                        AppMethodBeat.o(29308);
                        return;
                    } else if (this.FIA.FNJ != null) {
                        this.FNR = this.FIA.FNJ.MML;
                        AppMethodBeat.o(29308);
                        return;
                    }
                    break;
                case 547:
                    if (this.FIB.ftw()) {
                        Log.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        a(a.GET);
                        AppMethodBeat.o(29308);
                        return;
                    }
                    Log.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.FIB.FNI.BsG), Integer.valueOf(this.FIB.FNI.BsH));
                    a(a.UPLOAD_MORE);
                    AppMethodBeat.o(29308);
                    return;
                case 548:
                    this.FNR = this.FIC.FNL;
                    this.FIF = false;
                    if (!this.FIC.isComplete() && this.FIC.ftu()) {
                        a(b.loading, this.FIC.FNH.NpE);
                        Log.d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.FIC.FNH.NpE);
                    } else if (!this.FIC.ftu()) {
                        Log.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.FIC.isComplete()) {
                        Log.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.FIC.ftu()) {
                            str2 = this.FIC.FNH.NpE;
                        }
                        aSS(str2);
                        AppMethodBeat.o(29308);
                        return;
                    } else if (this.FNS) {
                        Log.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        a(a.GET);
                        AppMethodBeat.o(29308);
                        return;
                    } else {
                        Log.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.FNR));
                        final int i4 = this.FNR;
                        if (!this.FIG) {
                            if (this.FIH == null) {
                                this.FIH = new MTimerHandler(new MTimerHandler.CallBack() {
                                    /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass4 */

                                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                    public final boolean onTimerExpired() {
                                        AppMethodBeat.i(29285);
                                        if (VoiceTransTextUI.this.FIG) {
                                            AppMethodBeat.o(29285);
                                        } else {
                                            Log.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i4));
                                            VoiceTransTextUI.a(VoiceTransTextUI.this, a.GET);
                                            AppMethodBeat.o(29285);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            this.FIH.startTimer((long) (i4 * 1000));
                        }
                        AppMethodBeat.o(29308);
                        return;
                    }
                default:
                    AppMethodBeat.o(29308);
                    return;
            }
        } else {
            this.FIG = true;
            a(b.fail, (String) null);
        }
        AppMethodBeat.o(29308);
    }

    private void aSS(String str) {
        AppMethodBeat.i(29309);
        this.FIG = true;
        if (!Util.isNullOrNil(str)) {
            o.bic().a(aSJ(str));
        }
        a(b.done, str);
        AppMethodBeat.o(29309);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29310);
        fty();
        if (this.FIH != null) {
            this.FIH.stopTimer();
        }
        if (this.FNU != null) {
            EventCenter.instance.removeListener(this.FNU);
            this.FNU = null;
        }
        super.onDestroy();
        AppMethodBeat.o(29310);
    }

    private void ftA() {
        AppMethodBeat.i(29311);
        if (this.FNU == null) {
            this.FNU = new IListener<no>() {
                /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass5 */

                {
                    AppMethodBeat.i(161450);
                    this.__eventId = no.class.getName().hashCode();
                    AppMethodBeat.o(161450);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(no noVar) {
                    AppMethodBeat.i(29287);
                    no noVar2 = noVar;
                    Log.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
                    if (VoiceTransTextUI.this.FIA != null && !VoiceTransTextUI.this.FIG && (noVar2 instanceof no) && noVar2.dTI.dTJ == VoiceTransTextUI.this.FIA.FNK) {
                        Log.i("MicroMsg.VoiceTransTextUI", "");
                        if (VoiceTransTextUI.this.FIF) {
                            Log.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                            VoiceTransTextUI.this.FNS = true;
                        } else {
                            new MMHandler(VoiceTransTextUI.this.getMainLooper()).post(new Runnable() {
                                /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(29286);
                                    Log.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                                    if (VoiceTransTextUI.this.FIH != null) {
                                        VoiceTransTextUI.this.FIH.stopTimer();
                                    }
                                    VoiceTransTextUI.a(VoiceTransTextUI.this, a.GET);
                                    AppMethodBeat.o(29286);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(29287);
                    return false;
                }
            };
        }
        EventCenter.instance.addListener(this.FNU);
        AppMethodBeat.o(29311);
    }

    public void onClick(View view) {
        AppMethodBeat.i(29312);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(29312);
    }

    private void wg(final boolean z) {
        AppMethodBeat.i(29313);
        if (this.lTw == null || this.FNO == null) {
            AppMethodBeat.o(29313);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(29289);
                if (VoiceTransTextUI.this.lTw.getMeasuredHeight() >= VoiceTransTextUI.this.FNO.getMeasuredHeight()) {
                    VoiceTransTextUI.this.lTw.fullScroll(130);
                    int scrollY = VoiceTransTextUI.this.lTw.getScrollY();
                    VoiceTransTextUI.this.FNW = VoiceTransTextUI.this.lTw.getPaddingTop();
                    VoiceTransTextUI.this.FNW -= scrollY;
                    if (z) {
                        VoiceTransTextUI.this.lTw.setPadding(0, 0, 0, 0);
                        VoiceTransTextUI.this.FNQ.setVisibility(8);
                        VoiceTransTextUI.this.FNQ.setHeight(0);
                    } else if (VoiceTransTextUI.this.FNW > 0) {
                        VoiceTransTextUI.this.lTw.setPadding(0, VoiceTransTextUI.this.FNW, 0, 0);
                        AppMethodBeat.o(29289);
                        return;
                    }
                }
                AppMethodBeat.o(29289);
            }
        }, 5);
        AppMethodBeat.o(29313);
    }

    static /* synthetic */ void b(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(232117);
        voiceTransTextUI.BAN = Util.currentTicks();
        AppMethodBeat.o(232117);
    }

    static /* synthetic */ long i(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(232118);
        long currentTicks = Util.currentTicks() - voiceTransTextUI.BAN;
        AppMethodBeat.o(232118);
        return currentTicks;
    }

    static /* synthetic */ void k(VoiceTransTextUI voiceTransTextUI) {
        AppMethodBeat.i(232119);
        voiceTransTextUI.nrL = 0;
        voiceTransTextUI.Dn = 0;
        voiceTransTextUI.CJo = false;
        voiceTransTextUI.FNV = false;
        voiceTransTextUI.mHandler.removeMessages(0);
        AppMethodBeat.o(232119);
    }
}
