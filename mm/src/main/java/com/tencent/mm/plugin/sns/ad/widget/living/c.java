package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout;
import com.tencent.mm.plugin.sns.ad.widget.living.b;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.List;

public final class c implements LivingDescBarLayout.b, b.a {
    LivingStatusLayout DAL;
    LivingDescBarLayout DAM;
    g DAN;
    av DAO;
    int DAP = 0;
    String Dsr;

    public c(ViewGroup viewGroup, LivingDescBarLayout livingDescBarLayout, av avVar) {
        AppMethodBeat.i(202433);
        try {
            this.DAL = (LivingStatusLayout) viewGroup;
            this.DAM = livingDescBarLayout;
            this.DAO = avVar;
            AppMethodBeat.o(202433);
        } catch (Throwable th) {
            AppMethodBeat.o(202433);
        }
    }

    public final void a(String str, g gVar) {
        this.Dsr = str;
        this.DAN = gVar;
    }

    private void XX(int i2) {
        AppMethodBeat.i(202434);
        LivingStatusLayout livingStatusLayout = this.DAL;
        if (livingStatusLayout != null) {
            livingStatusLayout.setVisibility(0);
            livingStatusLayout.setLiveStatus(i2);
        }
        AppMethodBeat.o(202434);
    }

    private void eYw() {
        AppMethodBeat.i(202435);
        LivingDescBarLayout livingDescBarLayout = this.DAM;
        if (livingDescBarLayout == null) {
            AppMethodBeat.o(202435);
        } else if (getCount() == 0) {
            livingDescBarLayout.setVisibility(4);
            livingDescBarLayout.eYt();
            AppMethodBeat.o(202435);
        } else {
            livingDescBarLayout.setVisibility(0);
            livingDescBarLayout.setSlideAdapter(this);
            AppMethodBeat.o(202435);
        }
    }

    private void XY(int i2) {
        boolean z = true;
        AppMethodBeat.i(202436);
        av avVar = this.DAO;
        if (avVar != null) {
            String str = "";
            int i3 = i2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            int i4 = (65280 & i2) >> 8;
            if (i3 == 1) {
                if (i4 == 2) {
                    str = getString(R.string.h3v);
                    z = false;
                } else {
                    str = getString(R.string.h47);
                }
            } else if (i3 == 2) {
                str = getString(R.string.h43);
            } else if (i3 == 3) {
                if (i4 == 3) {
                    str = getString(R.string.h44);
                } else {
                    str = getString(R.string.h46);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (avVar.EwI != null) {
                        avVar.EwI.setText(str);
                    }
                } catch (Throwable th) {
                }
                try {
                    if (avVar.EwI != null) {
                        avVar.EwI.setEnabled(z);
                        if (z) {
                            avVar.EwI.setTextColor(avVar.mContext.getResources().getColor(R.color.fx));
                            AppMethodBeat.o(202436);
                            return;
                        }
                        avVar.EwI.setTextColor(-7829368);
                    }
                    AppMethodBeat.o(202436);
                    return;
                } catch (Throwable th2) {
                }
            }
        }
        AppMethodBeat.o(202436);
    }

    public final void setLiveStatus(int i2) {
        boolean z = false;
        AppMethodBeat.i(202437);
        if (i2 != this.DAP) {
            this.DAP = i2;
            if (i2 == 0) {
                eYx();
                AppMethodBeat.o(202437);
                return;
            }
            XX(i2);
            XY(i2);
            eYw();
            AppMethodBeat.o(202437);
        } else if (i2 == 0) {
            eYx();
            AppMethodBeat.o(202437);
        } else {
            XX(i2);
            XY(i2);
            LivingDescBarLayout livingDescBarLayout = this.DAM;
            if (livingDescBarLayout != null) {
                LivingDescBarLayout.a aVar = livingDescBarLayout.DAz;
                if (aVar != null && (aVar.DAD == null || aVar.DAD.getCount() <= 0)) {
                    z = true;
                }
                if (z) {
                    eYw();
                }
            }
            AppMethodBeat.o(202437);
        }
    }

    private void eYx() {
        AppMethodBeat.i(202438);
        LivingDescBarLayout livingDescBarLayout = this.DAM;
        if (livingDescBarLayout != null) {
            livingDescBarLayout.setVisibility(8);
            livingDescBarLayout.eYt();
        }
        LivingStatusLayout livingStatusLayout = this.DAL;
        if (livingStatusLayout != null) {
            livingStatusLayout.setVisibility(8);
        }
        AppMethodBeat.o(202438);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout.b
    public final int getCount() {
        AppMethodBeat.i(202439);
        List<String> eYy = eYy();
        if (eYy != null) {
            int size = eYy.size();
            AppMethodBeat.o(202439);
            return size;
        }
        AppMethodBeat.o(202439);
        return 0;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.living.LivingDescBarLayout.b
    public final String XW(int i2) {
        AppMethodBeat.i(202440);
        List<String> eYy = eYy();
        if (eYy == null || i2 < 0 || i2 >= eYy.size()) {
            AppMethodBeat.o(202440);
            return "";
        }
        String str = eYy.get(i2);
        AppMethodBeat.o(202440);
        return str;
    }

    private List<String> eYy() {
        int i2 = this.DAP & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        g gVar = this.DAN;
        if (gVar == null) {
            return null;
        }
        switch (i2) {
            case 1:
                return gVar.DrZ;
            case 2:
                return gVar.Dsa;
            case 3:
                return gVar.Dsb;
            default:
                return null;
        }
    }

    private Context getContext() {
        AppMethodBeat.i(202441);
        LivingDescBarLayout livingDescBarLayout = this.DAM;
        if (livingDescBarLayout != null) {
            Context context = livingDescBarLayout.getContext();
            AppMethodBeat.o(202441);
            return context;
        }
        AppMethodBeat.o(202441);
        return null;
    }

    private String getString(int i2) {
        AppMethodBeat.i(202442);
        Context context = getContext();
        if (context != null) {
            String string = context.getString(i2);
            AppMethodBeat.o(202442);
            return string;
        }
        AppMethodBeat.o(202442);
        return "";
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.living.b.a
    public final void fw(String str, int i2) {
        AppMethodBeat.i(202443);
        if (this.Dsr.equals(str) && this.DAP != i2) {
            setLiveStatus(i2);
        }
        AppMethodBeat.o(202443);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(202444);
        super.finalize();
        Log.d("SnsAd.LivingStatusController", "the SnsAdLivingStatusController is going to be gc:  ".concat(String.valueOf(this)));
        AppMethodBeat.o(202444);
    }
}
