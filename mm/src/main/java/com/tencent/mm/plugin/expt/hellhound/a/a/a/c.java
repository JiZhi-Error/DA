package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.LinkedList;

public final class c implements b {
    private Class<?> sBP;
    private Field sBQ;
    private Field sBR;
    private Field sCk;
    private Field sCl;
    private Field sCm;
    private Field sCn;
    private Field sCo;
    private Field sCp;

    public c() {
        AppMethodBeat.i(169314);
        try {
            this.sBP = Class.forName("com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem$BaseViewHolder");
            this.sBQ = this.sBP.getDeclaredField("timeLineObject");
            this.sBQ.setAccessible(true);
            this.sCk = this.sBP.getDeclaredField("isAd");
            this.sCk.setAccessible(true);
            this.sBR = Class.forName("com.tencent.mm.protocal.protobuf.TimeLineObject").getDeclaredField("Id");
            this.sBR.setAccessible(true);
            this.sCl = this.sBP.getDeclaredField("snsobj");
            this.sCl.setAccessible(true);
            Class<?> cls = Class.forName("com.tencent.mm.protocal.protobuf.SnsObject");
            this.sCn = cls.getDeclaredField("CommentUserList");
            this.sCn.setAccessible(true);
            this.sCm = cls.getDeclaredField("LikeCount");
            this.sCm.setAccessible(true);
            this.sCo = cls.getDeclaredField("Username");
            this.sCo.setAccessible(true);
            this.sCp = cls.getDeclaredField("Nickname");
            this.sCp.setAccessible(true);
            AppMethodBeat.o(169314);
        } catch (Exception e2) {
            AppMethodBeat.o(169314);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ac(View view, int i2) {
        String str;
        AppMethodBeat.i(169315);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(169315);
            return null;
        }
        try {
            if (!this.sBP.isInstance(tag)) {
                AppMethodBeat.o(169315);
                return null;
            }
            Object obj = this.sBQ.get(tag);
            if (obj == null) {
                AppMethodBeat.o(169315);
                return null;
            }
            try {
                str = (String) this.sBR.get(obj);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", e2, "getFeedParams.feedId: ", new Object[0]);
                str = null;
            }
            AppMethodBeat.o(169315);
            return str;
        } catch (Exception e3) {
            AppMethodBeat.o(169315);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void a(View view, PInt pInt, PInt pInt2, int i2) {
        int i3;
        int i4;
        Exception e2;
        AppMethodBeat.i(169316);
        pInt.value = 0;
        pInt2.value = 0;
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(169316);
            return;
        }
        try {
            if (this.sCl == null) {
                AppMethodBeat.o(169316);
                return;
            }
            Object obj = this.sCl.get(tag);
            if (obj != null) {
                i3 = ((Integer) this.sCm.get(obj)).intValue();
                try {
                    LinkedList linkedList = (LinkedList) this.sCn.get(obj);
                    if (linkedList != null) {
                        i4 = linkedList.size();
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", e2, "get feed info error!", new Object[0]);
                    i4 = 0;
                    pInt.value = i3;
                    pInt2.value = i4;
                    AppMethodBeat.o(169316);
                }
                i4 = 0;
            } else {
                i4 = 0;
                i3 = 0;
            }
            pInt.value = i3;
            pInt2.value = i4;
            AppMethodBeat.o(169316);
        } catch (Exception e4) {
            e2 = e4;
            i3 = 0;
            Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", e2, "get feed info error!", new Object[0]);
            i4 = 0;
            pInt.value = i3;
            pInt2.value = i4;
            AppMethodBeat.o(169316);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ad(View view, int i2) {
        String str;
        AppMethodBeat.i(169317);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(169317);
            return null;
        }
        try {
            if (this.sCl == null) {
                AppMethodBeat.o(169317);
                return null;
            }
            Object obj = this.sCl.get(tag);
            if (obj != null) {
                str = (String) this.sCo.get(obj);
                AppMethodBeat.o(169317);
                return str;
            }
            str = null;
            AppMethodBeat.o(169317);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", e2, "get feed info error!", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ae(View view, int i2) {
        String str;
        AppMethodBeat.i(185579);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(185579);
            return null;
        }
        try {
            if (this.sCl == null) {
                AppMethodBeat.o(185579);
                return null;
            }
            Object obj = this.sCl.get(tag);
            if (obj != null) {
                str = (String) this.sCp.get(obj);
                AppMethodBeat.o(185579);
                return str;
            }
            str = null;
            AppMethodBeat.o(185579);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SnsFeedParamCatcher", e2, "get feed info error!", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final boolean dP(View view) {
        boolean z;
        AppMethodBeat.i(184357);
        Object tag = view.getTag();
        if (tag == null) {
            AppMethodBeat.o(184357);
            return false;
        }
        try {
            if (!this.sBP.isInstance(tag)) {
                AppMethodBeat.o(184357);
                return false;
            }
            z = ((Boolean) this.sCk.get(tag)).booleanValue();
            AppMethodBeat.o(184357);
            return z;
        } catch (Exception e2) {
            z = false;
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void setRecyclerView(RecyclerView recyclerView) {
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String GY(int i2) {
        return null;
    }
}
