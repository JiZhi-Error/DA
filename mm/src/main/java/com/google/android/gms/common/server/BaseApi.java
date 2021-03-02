package com.google.android.gms.common.server;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseApi {

    public static abstract class BaseApiaryOptions<DerivedClassType extends BaseApiaryOptions<DerivedClassType>> {
        private final ArrayList<String> zzvt = new ArrayList<>();
        private final HashMap<String, String> zzvu = new HashMap<>();
        private String zzvv;
        private final BaseApiaryOptions<DerivedClassType>.Collector zzvw = new Collector();

        public final class Collector {
            private boolean zzvx;
            private boolean zzvy;
            private int zzvz;
            private StringBuilder zzwa = new StringBuilder();

            public Collector() {
                AppMethodBeat.i(11907);
                AppMethodBeat.o(11907);
            }

            private final void append(String str) {
                AppMethodBeat.i(11908);
                if (this.zzvx) {
                    this.zzvx = false;
                    this.zzwa.append(",");
                } else if (this.zzvy) {
                    this.zzvy = false;
                    this.zzwa.append(FilePathGenerator.ANDROID_DIR_SEP);
                }
                this.zzwa.append(str);
                AppMethodBeat.o(11908);
            }

            public final void addPiece(String str) {
                AppMethodBeat.i(11909);
                append(str);
                this.zzvy = true;
                AppMethodBeat.o(11909);
            }

            public final void beginSubCollection(String str) {
                AppMethodBeat.i(11911);
                append(str);
                this.zzwa.append("(");
                this.zzvz++;
                AppMethodBeat.o(11911);
            }

            public final void endSubCollection() {
                AppMethodBeat.i(11912);
                this.zzwa.append(")");
                this.zzvz--;
                if (this.zzvz == 0) {
                    BaseApiaryOptions.this.addField(this.zzwa.toString());
                    this.zzwa.setLength(0);
                    this.zzvx = false;
                    this.zzvy = false;
                    AppMethodBeat.o(11912);
                    return;
                }
                this.zzvx = true;
                AppMethodBeat.o(11912);
            }

            public final void finishPiece(String str) {
                AppMethodBeat.i(11910);
                append(str);
                if (this.zzvz == 0) {
                    BaseApiaryOptions.this.addField(this.zzwa.toString());
                    this.zzwa.setLength(0);
                    AppMethodBeat.o(11910);
                    return;
                }
                this.zzvx = true;
                AppMethodBeat.o(11910);
            }
        }

        public BaseApiaryOptions() {
            AppMethodBeat.i(11913);
            AppMethodBeat.o(11913);
        }

        private static String zzcy() {
            AppMethodBeat.i(11922);
            String valueOf = String.valueOf(!DeviceProperties.isUserBuild());
            AppMethodBeat.o(11922);
            return valueOf;
        }

        public final DerivedClassType addField(String str) {
            AppMethodBeat.i(11915);
            this.zzvt.add(str);
            AppMethodBeat.o(11915);
            return this;
        }

        @Deprecated
        public final String appendParametersToUrl(String str) {
            AppMethodBeat.i(11920);
            String append = BaseApi.append(str, "prettyPrint", zzcy());
            if (this.zzvv != null) {
                append = BaseApi.append(append, "trace", getTrace());
            }
            if (!this.zzvt.isEmpty()) {
                append = BaseApi.append(append, GraphRequest.FIELDS_PARAM, TextUtils.join(",", getFields().toArray()));
            }
            AppMethodBeat.o(11920);
            return append;
        }

        public void appendParametersToUrl(StringBuilder sb) {
            AppMethodBeat.i(11921);
            BaseApi.append(sb, "prettyPrint", zzcy());
            if (this.zzvv != null) {
                BaseApi.append(sb, "trace", getTrace());
            }
            if (!this.zzvt.isEmpty()) {
                BaseApi.append(sb, GraphRequest.FIELDS_PARAM, TextUtils.join(",", getFields().toArray()));
            }
            AppMethodBeat.o(11921);
        }

        public final DerivedClassType buildFrom(BaseApiaryOptions<?> baseApiaryOptions) {
            AppMethodBeat.i(11914);
            if (baseApiaryOptions.zzvv != null) {
                this.zzvv = baseApiaryOptions.zzvv;
            }
            if (!baseApiaryOptions.zzvt.isEmpty()) {
                this.zzvt.clear();
                this.zzvt.addAll(baseApiaryOptions.zzvt);
            }
            AppMethodBeat.o(11914);
            return this;
        }

        /* access modifiers changed from: protected */
        public final BaseApiaryOptions<DerivedClassType>.Collector getCollector() {
            return this.zzvw;
        }

        public final List<String> getFields() {
            return this.zzvt;
        }

        public final Map<String, String> getHeaders() {
            return this.zzvu;
        }

        public final String getTrace() {
            return this.zzvv;
        }

        public final DerivedClassType setEtag(String str) {
            AppMethodBeat.i(11917);
            DerivedClassType header = setHeader("ETag", str);
            AppMethodBeat.o(11917);
            return header;
        }

        public final DerivedClassType setHeader(String str, String str2) {
            AppMethodBeat.i(11916);
            this.zzvu.put(str, str2);
            AppMethodBeat.o(11916);
            return this;
        }

        public final DerivedClassType setTraceByLdap(String str) {
            AppMethodBeat.i(11918);
            String valueOf = String.valueOf("email:");
            String valueOf2 = String.valueOf(str);
            this.zzvv = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            AppMethodBeat.o(11918);
            return this;
        }

        public final DerivedClassType setTraceByToken(String str) {
            AppMethodBeat.i(11919);
            String valueOf = String.valueOf("token:");
            String valueOf2 = String.valueOf(str);
            this.zzvv = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            AppMethodBeat.o(11919);
            return this;
        }
    }

    public static class FieldCollection<Parent> {
        private final BaseApiaryOptions<?>.Collector zzvw;
        private final Parent zzwc;

        protected FieldCollection(Parent parent, BaseApiaryOptions<?>.Collector collector) {
            AppMethodBeat.i(11923);
            this.zzwc = parent == null ? (Parent) this : parent;
            this.zzvw = collector;
            AppMethodBeat.o(11923);
        }

        /* access modifiers changed from: protected */
        public BaseApiaryOptions<?>.Collector getCollector() {
            return this.zzvw;
        }

        /* access modifiers changed from: protected */
        public Parent getParent() {
            return this.zzwc;
        }
    }

    @Deprecated
    public static String append(String str, String str2, String str3) {
        AppMethodBeat.i(11926);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") != -1) {
            sb.append('&');
        } else {
            sb.append('?');
        }
        sb.append(str2);
        sb.append('=');
        sb.append(str3);
        String sb2 = sb.toString();
        AppMethodBeat.o(11926);
        return sb2;
    }

    public static void append(StringBuilder sb, String str, String str2) {
        AppMethodBeat.i(11927);
        if (sb.indexOf("?") != -1) {
            sb.append('&');
        } else {
            sb.append('?');
        }
        sb.append(str);
        sb.append('=');
        sb.append(str2);
        AppMethodBeat.o(11927);
    }

    public static String enc(String str) {
        AppMethodBeat.i(11924);
        Preconditions.checkNotNull(str, "Encoding a null parameter!");
        String encode = Uri.encode(str);
        AppMethodBeat.o(11924);
        return encode;
    }

    protected static List<String> enc(List<String> list) {
        AppMethodBeat.i(11925);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(enc(list.get(i2)));
        }
        AppMethodBeat.o(11925);
        return arrayList;
    }
}
