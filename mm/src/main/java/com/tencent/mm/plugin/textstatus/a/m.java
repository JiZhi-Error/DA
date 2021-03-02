package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import java.util.List;

public final class m extends com.tencent.mm.plugin.textstatus.g.a {
    private String TAG = "MicroMsg.SetStatusParam";

    public m() {
        this.Gah = null;
        this.mediaType = 1;
    }

    public static class a {
        m FXr = new m();

        public a() {
            AppMethodBeat.i(222801);
            AppMethodBeat.o(222801);
        }

        public final a aSY(String str) {
            this.FXr.Gae = str;
            return this;
        }

        public final a aSZ(String str) {
            this.FXr.FZB = str;
            return this;
        }

        public final a byo(String str) {
            this.FXr.desc = str;
            return this;
        }

        public final a aTa(String str) {
            this.FXr.thumbUrl = str;
            return this;
        }

        public final a fvy() {
            this.FXr.Gaf = false;
            return this;
        }

        public final a abL(int i2) {
            this.FXr.Gag = i2;
            return this;
        }

        public final a aTb(String str) {
            this.FXr.Gah = str;
            return this;
        }

        public final a aTc(String str) {
            this.FXr.Gai = str;
            return this;
        }

        public final a aTd(String str) {
            this.FXr.fuN = str;
            return this;
        }

        public final a aTe(String str) {
            this.FXr.iFo = str;
            return this;
        }

        public final a hE(List<r> list) {
            AppMethodBeat.i(222802);
            this.FXr.Gak.clear();
            this.FXr.Gak.addAll(list);
            AppMethodBeat.o(222802);
            return this;
        }

        public final a RR(long j2) {
            this.FXr.enterTime = j2;
            return this;
        }

        public final m fvz() {
            return this.FXr;
        }
    }
}
