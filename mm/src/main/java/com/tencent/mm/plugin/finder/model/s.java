package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;

public class s implements i, com.tencent.mm.view.recyclerview.a {
    private static final int uOg = 1;
    private static final int uOh = 2;
    static final int uOi = 3;
    public static final a uOj = new a((byte) 0);
    public boolean uNX;
    public SpannableString uNY;
    public boolean uNZ;
    public boolean uOa;
    public boolean uOb;
    public boolean uOc;
    public int uOd;
    public boolean uOe;
    public an uOf;

    public s(an anVar) {
        boolean z;
        p.h(anVar, "commentObj");
        AppMethodBeat.i(166383);
        this.uOf = anVar;
        if (!Util.isNullOrNil(this.uOf.getUsername())) {
            y yVar = y.vXH;
            if (y.awn(this.uOf.getUsername()) || ((PluginFinder) g.ah(PluginFinder.class)).isFriend(this.uOf.getUsername())) {
                z = true;
                this.uNX = z;
                this.uNZ = true;
                this.uOa = true;
                this.uOd = this.uOf.dyb().expandCommentCount;
                AppMethodBeat.o(166383);
            }
        }
        z = false;
        this.uNX = z;
        this.uNZ = true;
        this.uOa = true;
        this.uOd = this.uOf.dyb().expandCommentCount;
        AppMethodBeat.o(166383);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178313);
        AppMethodBeat.o(178313);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public long lT() {
        AppMethodBeat.i(248732);
        long j2 = this.uOf.dyb().commentId;
        AppMethodBeat.o(248732);
        return j2;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public int cxn() {
        AppMethodBeat.i(166381);
        if (this.uOf.field_actionInfo.tuf == 0) {
            int i2 = uOg;
            AppMethodBeat.o(166381);
            return i2;
        }
        int i3 = uOh;
        AppMethodBeat.o(166381);
        return i3;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public int a(i iVar) {
        AppMethodBeat.i(166382);
        p.h(iVar, "obj");
        AppMethodBeat.o(166382);
        return 0;
    }
}
