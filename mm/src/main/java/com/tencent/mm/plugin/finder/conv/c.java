package com.tencent.mm.plugin.finder.conv;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;

public final class c extends cf {
    private static final IAutoDBItem.MAutoDBInfo info = cf.ajs();
    public static final a tys = new a((byte) 0);
    public as contact;
    public String nickname;
    public CharSequence tyr;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(242700);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(242700);
        return mAutoDBInfo;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242703);
        AppMethodBeat.o(242703);
    }

    public final void prepare() {
        SpannableString c2;
        AppMethodBeat.i(242701);
        if (p.j(this.field_sessionId, "findersayhisessionholder")) {
            this.nickname = MMApplicationContext.getContext().getString(R.string.d1d);
            c2 = this.nickname;
        } else {
            com.tencent.mm.kernel.c.a af = g.af(l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            this.contact = ((l) af).aSN().Kn(this.field_sessionId);
            as asVar = this.contact;
            this.nickname = asVar != null ? asVar.arJ() : null;
            as asVar2 = this.contact;
            if (asVar2 == null || (c2 = asVar2.gBL()) == null) {
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), this.nickname);
            }
        }
        this.tyr = c2;
        AppMethodBeat.o(242701);
    }

    public final int hashCode() {
        return (int) this.systemRowid;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c) || ((c) obj).systemRowid != this.systemRowid) {
            return false;
        }
        return true;
    }

    public final boolean cZv() {
        return this.field_placedFlag > 0;
    }

    public final boolean cZw() {
        AppMethodBeat.i(242702);
        if (this.field_placedFlag <= 0 || !(!p.j(this.field_sessionId, "findersayhisessionholder"))) {
            AppMethodBeat.o(242702);
            return false;
        }
        AppMethodBeat.o(242702);
        return true;
    }
}
