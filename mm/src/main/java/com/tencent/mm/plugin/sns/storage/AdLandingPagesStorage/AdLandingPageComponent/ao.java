package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ao extends z {
    public String Eah = "";
    public String Eai = "";
    public int Eaj;
    public int Eak;
    public int Eal;
    public int Eam;
    public String Ean = "";
    public float borderWidth;
    public List<a> jzm = new ArrayList();

    public ao() {
        AppMethodBeat.i(96329);
        AppMethodBeat.o(96329);
    }

    public static class a {
        public String Eao = "";
        public String label = "";
        public float value;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(96327);
            if (obj == this) {
                AppMethodBeat.o(96327);
                return true;
            } else if (obj instanceof a) {
                a aVar = (a) obj;
                if (!aVar.label.equals(this.label) || !aVar.Eao.equals(this.Eao) || aVar.value != this.value) {
                    AppMethodBeat.o(96327);
                    return false;
                }
                AppMethodBeat.o(96327);
                return true;
            } else {
                AppMethodBeat.o(96327);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(96328);
            int hashCode = (int) (((float) (this.label.hashCode() + this.Eao.hashCode())) + this.value);
            AppMethodBeat.o(96328);
            return hashCode;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(96330);
        if (obj == this) {
            AppMethodBeat.o(96330);
            return true;
        } else if (obj instanceof ao) {
            ao aoVar = (ao) obj;
            if (aoVar.Eah != null ? aoVar.Eah.equals(this.Eah) : this.Eah == null) {
                if (aoVar.borderWidth == this.borderWidth && (aoVar.Eai != null ? aoVar.Eai.equals(this.Eai) : this.Eai == null) && aoVar.Eaj == this.Eaj && aoVar.Eak == this.Eak && aoVar.Eal == this.Eal && aoVar.Eam == this.Eam && (aoVar.jzm != null ? aoVar.jzm.equals(this.jzm) : this.jzm == null) && (aoVar.Ean != null ? aoVar.Ean.equals(this.Ean) : this.Ean == null)) {
                    AppMethodBeat.o(96330);
                    return true;
                }
            }
            AppMethodBeat.o(96330);
            return false;
        } else {
            AppMethodBeat.o(96330);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(96331);
        int hashCode = super.hashCode();
        AppMethodBeat.o(96331);
        return hashCode;
    }
}
