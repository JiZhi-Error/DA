package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fJ\u0014\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\fR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/platformtools/BaseProtoPage;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "()V", "TAG", "", "filePath", "clearPage", "", "constructor", "readFromFile", "Ljava/util/LinkedList;", "writeToFile", "dataList", "plugin-comm_release"})
public class d<T extends a> {
    private final String TAG = "MicroMsg.BaseProtoPage";
    private String filePath;

    /* access modifiers changed from: protected */
    public final void Sg(String str) {
        AppMethodBeat.i(169171);
        p.h(str, "filePath");
        this.filePath = str;
        AppMethodBeat.o(169171);
    }

    public final void r(LinkedList<T> linkedList) {
        AppMethodBeat.i(169172);
        p.h(linkedList, "dataList");
        String str = this.filePath;
        if (str == null) {
            p.btv("filePath");
        }
        if (Util.isNullOrNil(str)) {
            Log.e(this.TAG, "file path [%s] is invalid!");
            AppMethodBeat.o(169172);
            return;
        }
        synchronized (this) {
            try {
                String str2 = this.filePath;
                if (str2 == null) {
                    p.btv("filePath");
                }
                o oVar = new o(str2);
                if (!s.YS(oVar.getParent())) {
                    s.boN(oVar.getParent());
                }
                String str3 = this.filePath;
                if (str3 == null) {
                    p.btv("filePath");
                }
                if (!s.YS(str3)) {
                    String str4 = this.TAG;
                    StringBuilder sb = new StringBuilder("create new file ");
                    String str5 = this.filePath;
                    if (str5 == null) {
                        p.btv("filePath");
                    }
                    Log.i(str4, sb.append(str5).toString());
                    String str6 = this.filePath;
                    if (str6 == null) {
                        p.btv("filePath");
                    }
                    s.bpa(str6);
                }
                try {
                    int c2 = g.a.a.a.c(1, 8, linkedList);
                    String str7 = this.TAG;
                    StringBuilder append = new StringBuilder("write ").append(linkedList.size()).append(" items (total size ").append(c2).append(") to file ");
                    String str8 = this.filePath;
                    if (str8 == null) {
                        p.btv("filePath");
                    }
                    Log.i(str7, append.append(str8).toString());
                    byte[] bArr = new byte[c2];
                    g.a.a.c.a aVar = new g.a.a.c.a(bArr);
                    aVar.e(1, 8, linkedList);
                    aVar.hPu();
                    String str9 = this.filePath;
                    if (str9 == null) {
                        p.btv("filePath");
                    }
                    Integer.valueOf(s.C(str9, bArr));
                } catch (IOException e2) {
                    String str10 = this.TAG;
                    StringBuilder sb2 = new StringBuilder("write to file ");
                    String str11 = this.filePath;
                    if (str11 == null) {
                        p.btv("filePath");
                    }
                    Log.e(str10, sb2.append(str11).append(" occur error: ").append(e2.getMessage()).toString());
                    x xVar = x.SXb;
                }
            } finally {
                AppMethodBeat.o(169172);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.LinkedList<T extends com.tencent.mm.bw.a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedList<T> blq() {
        AppMethodBeat.i(169173);
        String str = this.filePath;
        if (str == null) {
            p.btv("filePath");
        }
        if (Util.isNullOrNil(str)) {
            Log.e(this.TAG, "file path [%s] is invalid!");
            AppMethodBeat.o(169173);
            return null;
        }
        synchronized (this) {
            try {
                String str2 = this.filePath;
                if (str2 == null) {
                    p.btv("filePath");
                }
                if (!s.YS(str2)) {
                    String str3 = this.TAG;
                    StringBuilder sb = new StringBuilder("file ");
                    String str4 = this.filePath;
                    if (str4 == null) {
                        p.btv("filePath");
                    }
                    Log.i(str3, sb.append(str4).append(" is not exist!").toString());
                    return null;
                }
                try {
                    String str5 = this.filePath;
                    if (str5 == null) {
                        p.btv("filePath");
                    }
                    String str6 = this.filePath;
                    if (str6 == null) {
                        p.btv("filePath");
                    }
                    byte[] aW = s.aW(str5, 0, (int) s.boW(str6));
                    g.a.a.a.a.a aVar = new g.a.a.a.a.a();
                    g.a.a.a.a aVar2 = new g.a.a.a.a(aW, aVar);
                    LinkedList<byte[]> awh = aVar2.awh(aVar2.hPk());
                    LinkedList<T> linkedList = (LinkedList<T>) new LinkedList();
                    p.g(awh, "listLst");
                    for (byte[] bArr : awh) {
                        Type genericSuperclass = getClass().getGenericSuperclass();
                        if (genericSuperclass == null) {
                            t tVar = new t("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                            AppMethodBeat.o(169173);
                            throw tVar;
                        }
                        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                        if (type == null) {
                            t tVar2 = new t("null cannot be cast to non-null type java.lang.Class<*>");
                            AppMethodBeat.o(169173);
                            throw tVar2;
                        }
                        Object newInstance = ((Class) type).newInstance();
                        if (newInstance == null) {
                            t tVar3 = new t("null cannot be cast to non-null type T");
                            AppMethodBeat.o(169173);
                            throw tVar3;
                        }
                        a aVar3 = (a) newInstance;
                        if (bArr == null) {
                            p.hyc();
                        }
                        g.a.a.a.a aVar4 = new g.a.a.a.a(bArr, aVar);
                        for (boolean z = true; z; z = aVar3.populateBuilderWithField(aVar4, aVar3, a.getNextFieldNumber(aVar4))) {
                        }
                        linkedList.add(aVar3);
                    }
                    String str7 = this.TAG;
                    StringBuilder append = new StringBuilder("read ").append(linkedList.size()).append(" items (total size ").append(aW.length).append(") from file ");
                    String str8 = this.filePath;
                    if (str8 == null) {
                        p.btv("filePath");
                    }
                    Log.i(str7, append.append(str8).toString());
                    AppMethodBeat.o(169173);
                    return linkedList;
                } catch (Exception e2) {
                    Log.e(this.TAG, "parse proto from file occur error: " + e2.getMessage());
                    AppMethodBeat.o(169173);
                    return null;
                }
            } finally {
                AppMethodBeat.o(169173);
            }
        }
    }

    public final void blr() {
        AppMethodBeat.i(169174);
        String str = this.filePath;
        if (str == null) {
            p.btv("filePath");
        }
        if (Util.isNullOrNil(str)) {
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder("file path [");
            String str3 = this.filePath;
            if (str3 == null) {
                p.btv("filePath");
            }
            Log.e(str2, sb.append(str3).append("] is invalid!").toString());
            AppMethodBeat.o(169174);
            return;
        }
        synchronized (this) {
            try {
                String str4 = this.filePath;
                if (str4 == null) {
                    p.btv("filePath");
                }
                s.deleteFile(str4);
            } finally {
                AppMethodBeat.o(169174);
            }
        }
    }
}
