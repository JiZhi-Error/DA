package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.c;
import java.util.HashMap;

@a(gRF = c.class)
public class g extends a implements c {
    private static HashMap<String, f> PnL = new HashMap<>();
    private f BCr = null;
    private Bitmap PnH;
    private ImageView PnI;
    private boolean PnJ = true;
    private final MStorage.IOnStorageChange PnK = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.chatting.d.g.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(35166);
            Log.d("MicroMsg.ChattingUI.ChattingBackgroundComponent", "onBGChange event:%s", str);
            if (str != null && (str.equals(g.this.dom.getTalkerUserName()) || str.equals("*"))) {
                g.this.geA();
            }
            AppMethodBeat.o(35166);
        }
    };
    private ImageView tlu;

    public g() {
        AppMethodBeat.i(35167);
        AppMethodBeat.o(35167);
    }

    public final void geA() {
        com.tencent.mm.bb.a Pp;
        int i2;
        String as;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(35168);
        if (((ai) this.dom.bh(ai.class)).gQN()) {
            Pp = null;
        } else {
            Pp = v.bew().Pp(this.dom.getTalkerUserName());
        }
        if (Pp == null) {
            bg.aVF();
            i2 = ((Integer) com.tencent.mm.model.c.azQ().get(12311, (Object) -2)).intValue();
        } else {
            i2 = Pp.jgE;
        }
        if (i2 == -2) {
            setBackgroundColor(gPq());
            cJ(this.dom.Pwc.getContext(), "chatting/purecolor_chat.xml");
            AppMethodBeat.o(35168);
            return;
        }
        v.bev();
        int dd = r.dd(this.dom.Pwc.getContext());
        switch (dd) {
            case 1:
            case 2:
                this.PnJ = false;
                break;
            default:
                this.PnJ = true;
                break;
        }
        if (i2 == 0) {
            switch (dd) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i3 = R.drawable.nb;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            if (i3 != -1) {
                gPp();
                try {
                    this.PnH = BitmapFactory.decodeResource(this.dom.Pwc.getMMResources(), i3);
                } catch (IncompatibleClassChangeError e2) {
                    Log.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2);
                    AppMethodBeat.o(35168);
                    throw incompatibleClassChangeError;
                } catch (Throwable th) {
                }
                if (this.PnH == null) {
                    Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, resId = ".concat(String.valueOf(i3)));
                    setBackgroundColor(this.dom.Pwc.getMMResources().getColor(R.color.j5));
                } else {
                    if (this.PnI == null) {
                        this.PnI = (ImageView) this.dom.findViewById(R.id.aub);
                    }
                    if (this.tlu == null) {
                        this.tlu = (ImageView) this.dom.findViewById(R.id.a35);
                    }
                    if (this.PnI != null) {
                        this.PnI.setImageBitmap(this.PnH);
                    }
                    if (this.tlu != null) {
                        this.tlu.setVisibility(ao.isDarkMode() ? 0 : 8);
                    }
                }
                cJ(this.dom.Pwc.getContext(), "chatting/reserved_chat.xml");
            }
            AppMethodBeat.o(35168);
            return;
        }
        r bev = v.bev();
        if (i2 > 0) {
            cJ(this.dom.Pwc.getContext(), "chatting/default_chat.xml");
            switch (dd) {
                case 1:
                    as = bev.dw(i2, 1) + "horizontal_hdpi.jpg";
                    break;
                case 2:
                    as = bev.dw(i2, 1) + "horizontal_ldpi.jpg";
                    break;
                case 3:
                    as = bev.dw(i2, 1) + "vertical_hdpi.jpg";
                    break;
                case 4:
                    as = bev.dw(i2, 1) + "vertical_ldpi.jpg";
                    break;
                default:
                    as = null;
                    break;
            }
        } else {
            cJ(this.dom.Pwc.getContext(), "chatting/default_chat.xml");
            if (Pp == null) {
                as = r.as(BuildConfig.KINDA_DEFAULT, dd);
            } else {
                as = r.as(this.dom.getTalkerUserName(), dd);
            }
        }
        gPp();
        this.PnH = u.Sq(as);
        if (this.PnH == null) {
            Log.e("MicroMsg.ChattingUI.ChattingBackgroundComponent", "setBackground decodeFile fail, bm is null, path = ".concat(String.valueOf(as)));
            setBackgroundColor(gPq());
            AppMethodBeat.o(35168);
            return;
        }
        if (this.PnI == null) {
            this.PnI = (ImageView) this.dom.findViewById(R.id.aub);
        }
        if (this.tlu == null) {
            this.tlu = (ImageView) this.dom.findViewById(R.id.a35);
        }
        if (this.PnI != null) {
            this.PnI.setImageBitmap(this.PnH);
        }
        if (this.tlu != null) {
            ImageView imageView = this.tlu;
            if (!ao.isDarkMode()) {
                i4 = 8;
            }
            imageView.setVisibility(i4);
        }
        AppMethodBeat.o(35168);
    }

    private void gPp() {
        AppMethodBeat.i(35169);
        if (this.PnH != null && !this.PnH.isRecycled()) {
            Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "recycle bitmap:%s", this.PnH.toString());
            this.PnH.recycle();
        }
        if (this.PnI != null) {
            this.PnI.setImageBitmap(null);
        }
        if (this.tlu != null) {
            this.tlu.setVisibility(8);
        }
        AppMethodBeat.o(35169);
    }

    private int gPq() {
        AppMethodBeat.i(35170);
        int color = this.dom.Pwc.getMMResources().getColor(R.color.kz);
        AppMethodBeat.o(35170);
        return color;
    }

    private void setBackgroundColor(int i2) {
        AppMethodBeat.i(35171);
        gPp();
        if (this.PnI == null) {
            View findViewById = this.dom.findViewById(R.id.auc);
            if (findViewById != null) {
                findViewById.setBackgroundColor(i2);
            }
            AppMethodBeat.o(35171);
            return;
        }
        this.PnI.setImageDrawable(new ColorDrawable(i2));
        AppMethodBeat.o(35171);
    }

    static {
        AppMethodBeat.i(35176);
        AppMethodBeat.o(35176);
    }

    private boolean cJ(Context context, String str) {
        AppMethodBeat.i(35172);
        if (PnL.containsKey(str)) {
            this.BCr = PnL.get(str);
            AppMethodBeat.o(35172);
            return true;
        }
        try {
            this.BCr = new f(Util.convertStreamToString(context.getAssets().open(str)), this.dom.Pwc.getContext());
            PnL.put(str, this.BCr);
            AppMethodBeat.o(35172);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChattingUI.ChattingBackgroundComponent", e2, "", new Object[0]);
            AppMethodBeat.o(35172);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.c
    public final f gPr() {
        return this.BCr;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.c
    public final boolean gPs() {
        AppMethodBeat.i(233050);
        com.tencent.mm.bb.a Pp = v.bew().Pp(this.dom.getTalkerUserName());
        if (Pp == null || Pp.jgE == -2) {
            AppMethodBeat.o(233050);
            return false;
        }
        AppMethodBeat.o(233050);
        return true;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35173);
        Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingEnterAnimStart]");
        geA();
        AppMethodBeat.o(35173);
    }

    @Override // com.tencent.mm.ui.l
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(233051);
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 1 || this.PnJ) {
            if (configuration.orientation == 2 && this.PnJ) {
                geA();
            }
            AppMethodBeat.o(233051);
            return;
        }
        geA();
        AppMethodBeat.o(233051);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(35175);
        Log.i("MicroMsg.ChattingUI.ChattingBackgroundComponent", "[onChattingExitAnimEnd]");
        if (bg.aAc()) {
            v.bew().remove(this.PnK);
            v.bev().remove(this.PnK);
        }
        gPp();
        AppMethodBeat.o(35175);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35174);
        v.bew().add(this.PnK);
        v.bev().add(this.PnK);
        AppMethodBeat.o(35174);
    }
}
