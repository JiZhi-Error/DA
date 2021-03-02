package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.d;
import com.tencent.mm.plugin.editor.model.a.h;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.b;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class c {
    private static volatile c qQo = null;
    public ArrayList<a> mDataList = null;
    public com.tencent.mm.plugin.editor.model.nativenote.b.a qQp = null;
    public aml qQq = null;
    public int qQr = 0;
    public int qQs = 0;
    public int qQt = 0;

    private c() {
    }

    public static c cDo() {
        AppMethodBeat.i(181727);
        if (qQo == null) {
            synchronized (c.class) {
                try {
                    if (qQo == null) {
                        qQo = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(181727);
                    throw th;
                }
            }
        }
        c cVar = qQo;
        AppMethodBeat.o(181727);
        return cVar;
    }

    public final int size() {
        AppMethodBeat.i(181728);
        if (this.mDataList != null) {
            int size = this.mDataList.size();
            AppMethodBeat.o(181728);
            return size;
        }
        AppMethodBeat.o(181728);
        return 0;
    }

    public final a Fw(int i2) {
        AppMethodBeat.i(181729);
        if (this.mDataList == null || i2 < 0 || i2 >= this.mDataList.size()) {
            AppMethodBeat.o(181729);
            return null;
        }
        a aVar = this.mDataList.get(i2);
        AppMethodBeat.o(181729);
        return aVar;
    }

    public final boolean e(a aVar) {
        boolean z = true;
        AppMethodBeat.i(181730);
        synchronized (this) {
            if (aVar != null) {
                try {
                    if (this.mDataList != null) {
                        this.mDataList.add(aVar);
                        a(aVar, true);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(181730);
                    throw th;
                }
            }
            z = false;
        }
        AppMethodBeat.o(181730);
        return z;
    }

    public final boolean b(int i2, ArrayList<a> arrayList) {
        boolean z;
        int i3;
        int i4;
        AppMethodBeat.i(181731);
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(181731);
            return false;
        }
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i5 = 0;
                    i3 = 0;
                    i4 = i2;
                    while (i5 < arrayList.size() && i4 >= 0 && i4 <= this.mDataList.size()) {
                        a aVar = arrayList.get(i5);
                        if (aVar != null) {
                            f(aVar);
                            this.mDataList.add(i4, aVar);
                            i3++;
                            i4++;
                            a(aVar, true);
                        }
                        i5++;
                        i3 = i3;
                    }
                    z = true;
                } else {
                    z = false;
                    i3 = 0;
                    i4 = i2;
                }
            } finally {
                AppMethodBeat.o(181731);
            }
        }
        if (z && this.qQp != null) {
            this.qQp.ft(i4 - i3, i3);
        }
        return z;
    }

    public final boolean a(int i2, a aVar) {
        boolean z = true;
        AppMethodBeat.i(181732);
        synchronized (this) {
            try {
                if (this.mDataList == null || i2 < 0 || i2 > this.mDataList.size()) {
                    z = false;
                } else {
                    this.mDataList.add(i2, aVar);
                    a(aVar, true);
                }
            } finally {
                AppMethodBeat.o(181732);
            }
        }
        if (z && this.qQp != null) {
            this.qQp.Fs(i2);
            if (i2 > 0) {
                this.qQp.fu(i2 - 1, this.mDataList.size() - (i2 - 1));
            } else {
                this.qQp.fu(i2, this.mDataList.size() - i2);
            }
        }
        return z;
    }

    private boolean b(int i2, a aVar) {
        boolean z = true;
        AppMethodBeat.i(181733);
        if (aVar == null || this.mDataList == null || i2 < 0 || i2 > this.mDataList.size()) {
            z = false;
        } else {
            this.mDataList.add(i2, aVar);
            a(aVar, true);
        }
        AppMethodBeat.o(181733);
        return z;
    }

    public final boolean ae(int i2, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(181734);
        synchronized (this) {
            try {
                if (this.mDataList != null && i2 >= 0 && i2 < this.mDataList.size()) {
                    a(this.mDataList.get(i2), false);
                    this.mDataList.remove(i2);
                    z2 = true;
                }
            } finally {
                AppMethodBeat.o(181734);
            }
        }
        if (z2 && z && this.qQp != null) {
            this.qQp.Ft(i2);
            if (i2 > 0) {
                this.qQp.fu(i2 - 1, this.mDataList.size() - (i2 - 1));
            } else {
                this.qQp.fu(i2, this.mDataList.size() - i2);
            }
        }
        return z2;
    }

    private boolean Fx(int i2) {
        boolean z;
        AppMethodBeat.i(181735);
        if (this.mDataList == null || i2 < 0 || i2 >= this.mDataList.size()) {
            z = false;
        } else {
            a(this.mDataList.get(i2), false);
            this.mDataList.remove(i2);
            z = true;
        }
        AppMethodBeat.o(181735);
        return z;
    }

    public final void Fy(int i2) {
        AppMethodBeat.i(181736);
        if (this.qQp != null) {
            this.qQp.Fr(i2);
        }
        AppMethodBeat.o(181736);
    }

    public final void cDp() {
        AppMethodBeat.i(181737);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.mDataList != null ? this.mDataList.size() : 0);
        Log.i("MicroMsg.EditorDataManager", "clear mDataList, size:%d", objArr);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    this.mDataList.clear();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(181737);
                throw th;
            }
        }
        this.qQt = 0;
        this.qQs = 0;
        AppMethodBeat.o(181737);
    }

    public final void af(int i2, boolean z) {
        AppMethodBeat.i(181738);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    if (i2 >= 0 && i2 < this.mDataList.size()) {
                        a aVar = this.mDataList.get(i2);
                        if (!(aVar == null || aVar.qPH == z)) {
                            aVar.qPH = z;
                            if (this.qQp != null) {
                                this.qQp.Fr(i2);
                            }
                        }
                    } else if (i2 == -1) {
                        for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
                            a aVar2 = this.mDataList.get(i3);
                            if (!(aVar2 == null || aVar2.qPH == z)) {
                                aVar2.qPH = z;
                                if (this.qQp != null) {
                                    this.qQp.Fr(i3);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(181738);
                }
            } finally {
                AppMethodBeat.o(181738);
            }
        }
    }

    public final int cDq() {
        int i2;
        AppMethodBeat.i(181739);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.mDataList.size()) {
                            break;
                        } else if (this.mDataList.get(i3).qPA) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                i2 = -1;
            } finally {
                AppMethodBeat.o(181739);
            }
        }
        return i2;
    }

    public final void cDr() {
        AppMethodBeat.i(181740);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    Iterator<a> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        next.qPA = false;
                        next.qPG = false;
                    }
                }
            } finally {
                AppMethodBeat.o(181740);
            }
        }
    }

    private void cDs() {
        AppMethodBeat.i(181741);
        if (this.mDataList != null) {
            Iterator<a> it = this.mDataList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                next.qPA = false;
                next.qPG = false;
            }
        }
        AppMethodBeat.o(181741);
    }

    public final void ag(int i2, boolean z) {
        AppMethodBeat.i(181742);
        synchronized (this) {
            try {
                if (this.mDataList != null && i2 >= 0 && i2 < this.mDataList.size()) {
                    for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
                        if (i3 == i2) {
                            this.mDataList.get(i3).qPA = true;
                            this.mDataList.get(i3).qPG = z;
                        } else {
                            this.mDataList.get(i3).qPA = false;
                            this.mDataList.get(i3).qPG = false;
                        }
                    }
                    AppMethodBeat.o(181742);
                }
            } finally {
                AppMethodBeat.o(181742);
            }
        }
    }

    public final int cDt() {
        int i2;
        AppMethodBeat.i(181743);
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < this.mDataList.size()) {
                            if (this.mDataList.get(i3).getType() == 4 && ((m) this.mDataList.get(i3)).qPX.booleanValue()) {
                                i2 = i3;
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                }
                i2 = -1;
            } finally {
                AppMethodBeat.o(181743);
            }
        }
        return i2;
    }

    public final String cDu() {
        String sb;
        AppMethodBeat.i(181744);
        synchronized (this) {
            try {
                if (this.qQr == 0 && this.mDataList != null) {
                    Iterator<a> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (dVar.qPN.startsWith("WeNote_")) {
                            int i2 = Util.getInt(dVar.qPN.substring(7), -1);
                            if (i2 <= this.qQr) {
                                i2 = this.qQr;
                            }
                            this.qQr = i2;
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder("WeNote_");
                int i3 = this.qQr + 1;
                this.qQr = i3;
                sb = sb2.append(i3).toString();
            } finally {
                AppMethodBeat.o(181744);
            }
        }
        return sb;
    }

    private String cDv() {
        AppMethodBeat.i(181745);
        if (this.qQr == 0 && this.mDataList != null) {
            Iterator<a> it = this.mDataList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.qPN.startsWith("WeNote_")) {
                    int i2 = Util.getInt(dVar.qPN.substring(7), -1);
                    if (i2 <= this.qQr) {
                        i2 = this.qQr;
                    }
                    this.qQr = i2;
                }
            }
        }
        StringBuilder sb = new StringBuilder("WeNote_");
        int i3 = this.qQr + 1;
        this.qQr = i3;
        String sb2 = sb.append(i3).toString();
        AppMethodBeat.o(181745);
        return sb2;
    }

    public final String cDw() {
        AppMethodBeat.i(181746);
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                if (this.mDataList == null || this.mDataList.size() <= 0) {
                    return "";
                }
                for (int i2 = 0; i2 < this.mDataList.size(); i2++) {
                    a aVar = this.mDataList.get(i2);
                    switch (aVar.getType()) {
                        case -1:
                            sb.append("<hr/>");
                            break;
                        case 1:
                            j jVar = (j) aVar;
                            if (Util.isNullOrNil(jVar.content)) {
                                sb.append("<br/>");
                                break;
                            } else {
                                sb.append(jVar.content);
                                if (i2 + 1 < this.mDataList.size() && this.mDataList.get(i2 + 1).getType() == 1 && !Util.isNullOrNil(((j) this.mDataList.get(i2 + 1)).content)) {
                                    sb.append("<br/>");
                                    break;
                                }
                            }
                        case 2:
                            sb.append(cY(((h) aVar).qPN, 2));
                            break;
                        case 4:
                            sb.append(cY(((m) aVar).qPN, 4));
                            break;
                        case 6:
                            sb.append(cY(((l) aVar).qPN, 6));
                            break;
                    }
                }
                String sb2 = new StringBuilder(sb.toString().replaceAll("\n", "<br/>")).toString();
                AppMethodBeat.o(181746);
                return sb2;
            } finally {
                AppMethodBeat.o(181746);
            }
        }
    }

    private static String cY(String str, int i2) {
        AppMethodBeat.i(181747);
        String format = String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", Integer.valueOf(i2), str, str);
        AppMethodBeat.o(181747);
        return format;
    }

    public final anb alU(String str) {
        boolean z;
        byte[] bArr;
        AppMethodBeat.i(181748);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.EditorDataManager", "getFavProtoItem error, htmlstr is null or nil");
            AppMethodBeat.o(181748);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            for (int i2 = 0; i2 < this.mDataList.size(); i2++) {
                try {
                    a aVar = this.mDataList.get(i2);
                    if (Util.isNullOrNil(aVar.dLl)) {
                        aVar.dLl = b.alR(aVar.toString());
                    }
                    if (aVar.getType() == -1) {
                        if (arrayList.size() <= 0 || ((d) arrayList.get(arrayList.size() - 1)).type != 1) {
                            j jVar = new j();
                            jVar.content = "\n";
                            jVar.dLl = aVar.dLl;
                            jVar.qPN = "-1";
                            jVar.type = 1;
                            jVar.qPM = null;
                            arrayList.add(jVar);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            j jVar2 = (j) arrayList.get(arrayList.size() - 1);
                            jVar2.content = sb.append(jVar2.content).append("\n").toString();
                        }
                    } else if (aVar.getType() >= -1) {
                        if ((aVar.getType() == 6 || aVar.getType() == 4) && Util.isNullOrNil(((d) aVar).dUs)) {
                            aml aml = new aml();
                            aml.bgs(aVar.dLl);
                            aml.bgp(aVar.cDg());
                            String b2 = b.b(aml);
                            if (s.YS(b2)) {
                                Log.e("MicroMsg.EditorDataManager", "getFavProtoItem, type = %d, localfile exist, but localpath is null or nil, set path here", Integer.valueOf(aVar.getType()));
                                ((d) aVar).dUs = b2;
                            }
                        }
                        if (aVar.getType() != 1) {
                            arrayList.add((d) aVar);
                        } else {
                            j jVar3 = (j) aVar;
                            if (!Util.isNullOrNil(jVar3.content)) {
                                if (arrayList.size() <= 0 || ((d) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                    j jVar4 = new j();
                                    jVar4.content = jVar3.content;
                                    jVar4.dLl = jVar3.dLl;
                                    jVar4.qPN = jVar3.qPN;
                                    jVar4.type = jVar3.type;
                                    jVar4.qPM = null;
                                    arrayList.add(jVar4);
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    j jVar5 = (j) arrayList.get(arrayList.size() - 1);
                                    jVar5.content = sb2.append(jVar5.content).append(jVar3.content).toString();
                                }
                                if (i2 + 1 < this.mDataList.size() && this.mDataList.get(i2 + 1).getType() == 1 && !Util.isNullOrNil(((j) this.mDataList.get(i2 + 1)).content)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    j jVar6 = (j) arrayList.get(arrayList.size() - 1);
                                    jVar6.content = sb3.append(jVar6.content).append("<br/>").toString();
                                }
                            } else if (arrayList.size() <= 0 || ((d) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                j jVar7 = new j();
                                jVar7.content = "<br/>";
                                jVar7.dLl = jVar3.dLl;
                                jVar7.qPN = jVar3.qPN;
                                jVar7.type = jVar3.type;
                                jVar7.qPM = null;
                                arrayList.add(jVar7);
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                j jVar8 = (j) arrayList.get(arrayList.size() - 1);
                                jVar8.content = sb4.append(jVar8.content).append("<br/>").toString();
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(181748);
                    throw th;
                }
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        try {
            bArr = replaceAll.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            z = false;
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.EditorDataManager", e2, "", new Object[0]);
            Log.e("MicroMsg.EditorDataManager", "writehtmlfile, use utf-8 encoding error, use default encoding");
            z = true;
            bArr = null;
        }
        this.qQq.ajd(8);
        this.qQq.bgC("WeNoteHtmlFile");
        this.qQq.At(true);
        this.qQq.bgp(".htm");
        this.qQq.bgs(b.alR(this.qQq.toString()));
        String b3 = b.b(this.qQq);
        Log.i("MicroMsg.EditorDataManager", "getFavProtoItem: save note html file, path is %s", b3);
        o oVar = new o(b3);
        if (oVar.exists()) {
            oVar.delete();
        }
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.EditorDataManager", e3, "", new Object[0]);
                AppMethodBeat.o(181748);
                return null;
            }
        }
        if (z || s.f(b3, bArr, bArr.length) != 0) {
            Log.i("MicroMsg.EditorDataManager", "writefile error, return");
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.cc0), 1).show();
            AppMethodBeat.o(181748);
            return null;
        }
        this.qQq.bgt(b3);
        Log.i("MicroMsg.EditorDataManager", "do EditorBase.ConvertNote2FavProtoItem");
        anb a2 = com.tencent.mm.plugin.editor.model.a.a(replaceAll, arrayList, this.qQq);
        AppMethodBeat.o(181748);
        return a2;
    }

    public final int a(a aVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(181749);
        if (aVar == null) {
            AppMethodBeat.o(181749);
            return -1;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        int a2 = a(arrayList, wXRTEditText, true, z, z2, z3);
        AppMethodBeat.o(181749);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x026c, code lost:
        r1 = cDo().size() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0278, code lost:
        r6 = new com.tencent.mm.plugin.editor.model.a.j();
        r6.type = 1;
        r6.content = "";
        r6.qPC = 0;
        r6.qPA = true;
        r6.qPG = false;
        b(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x028f, code lost:
        if (r3 != 0) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0291, code lost:
        r10.qQp.fu(r3, cDo().size() - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00eb, code lost:
        if ((r2 - 1) < 0) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f7, code lost:
        if ((r2 - 1) >= cDo().size()) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f9, code lost:
        r1 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fb, code lost:
        if (r16 == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fd, code lost:
        r1 = r1 + 1;
        r2 = r2 + 1;
        cDs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010c, code lost:
        if (r1 >= cDo().size()) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010e, code lost:
        r6 = cDo().Fw(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0116, code lost:
        if (r6 == null) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0118, code lost:
        r6.qPC = 0;
        r6.qPA = true;
        r6.qPG = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0120, code lost:
        if (r10.qQp == null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0122, code lost:
        r2 = r2 - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0123, code lost:
        if (r4 == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0125, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0127, code lost:
        if (r3 < 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0129, code lost:
        if (r2 <= 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x012b, code lost:
        r10.qQp.ft(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0130, code lost:
        if (r3 <= 0) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0132, code lost:
        r10.qQp.fu(r3 - 1, cDo().size() - (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0145, code lost:
        if (r15 == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0147, code lost:
        r10.qQp.cCw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014c, code lost:
        r10.qQp.Fu(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0151, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(181750);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.editor.model.a.a> r11, com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 689
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.c.a(java.util.ArrayList, com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText, boolean, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0194, code lost:
        if ((r2 - 1) < 0) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a0, code lost:
        if ((r2 - 1) >= cDo().size()) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a2, code lost:
        r1 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a6, code lost:
        if (r9.qQp == null) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a8, code lost:
        r2 = r2 - r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a9, code lost:
        if (r3 == false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ab, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ad, code lost:
        if (r5 < 0) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01af, code lost:
        if (r2 <= 0) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b1, code lost:
        r9.qQp.ft(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b6, code lost:
        if (r5 <= 0) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b8, code lost:
        r9.qQp.fu(r5 - 1, cDo().size() - (r5 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ca, code lost:
        r9.qQp.Fu(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cf, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(181751);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01dd, code lost:
        r1 = cDo().size() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e8, code lost:
        if (r5 != 0) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01ea, code lost:
        r9.qQp.fu(r5, cDo().size() - r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.editor.model.a.a> r10, int r11, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 513
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.c.a(java.util.ArrayList, int, int, int, int):int");
    }

    private void f(a aVar) {
        AppMethodBeat.i(181752);
        if (aVar == null) {
            AppMethodBeat.o(181752);
            return;
        }
        d dVar = (d) aVar;
        if (dVar.getType() > 1 && Util.isNullOrNil(dVar.qPN)) {
            dVar.qPN = cDv();
        }
        if (Util.isNullOrNil(aVar.dLl)) {
            aVar.dLl = b.alR(aVar.toString());
        }
        AppMethodBeat.o(181752);
    }

    public final ArrayList<a> cDx() {
        AppMethodBeat.i(181753);
        if (this.mDataList == null) {
            AppMethodBeat.o(181753);
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        synchronized (this) {
            try {
                Iterator<a> it = this.mDataList.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.tencent.mm.plugin.editor.b.a(it.next()));
                }
            } finally {
                AppMethodBeat.o(181753);
            }
        }
        return arrayList;
    }

    public final void T(ArrayList<WXRTEditText> arrayList) {
        AppMethodBeat.i(181754);
        if (arrayList == null) {
            AppMethodBeat.o(181754);
            return;
        }
        arrayList.clear();
        synchronized (this) {
            try {
                if (this.mDataList != null) {
                    Iterator<a> it = this.mDataList.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (next.qPF != null) {
                            arrayList.add(next.qPF);
                        } else if (!(next.qPD == null || next.qPE == null)) {
                            arrayList.add(next.qPD);
                            arrayList.add(next.qPE);
                        }
                    }
                    AppMethodBeat.o(181754);
                }
            } finally {
                AppMethodBeat.o(181754);
            }
        }
    }

    public final boolean U(ArrayList<a> arrayList) {
        AppMethodBeat.i(181755);
        StringBuilder sb = new StringBuilder();
        Iterator<a> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next.getType() != 1) {
                i2++;
            } else {
                sb.append(((j) next).content);
            }
        }
        boolean fw = fw(com.tencent.mm.plugin.editor.b.alJ(sb.toString()), i2);
        AppMethodBeat.o(181755);
        return fw;
    }

    public final boolean fw(int i2, int i3) {
        boolean z;
        boolean z2;
        if (i2 < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i3 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z || this.qQs + i2 <= 16384) {
            return z2 && this.qQt + i3 > 30;
        }
        return true;
    }

    public final void cDy() {
        AppMethodBeat.i(181756);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(181726);
                synchronized (c.this) {
                    try {
                        if (c.this.mDataList != null) {
                            StringBuilder sb = new StringBuilder();
                            Iterator it = c.this.mDataList.iterator();
                            int i2 = 0;
                            while (it.hasNext()) {
                                a aVar = (a) it.next();
                                if (aVar.getType() != 1) {
                                    i2++;
                                } else {
                                    sb.append(((j) aVar).content);
                                }
                            }
                            c.this.qQs = com.tencent.mm.plugin.editor.b.alJ(sb.toString());
                            c.this.qQt = i2;
                            AppMethodBeat.o(181726);
                        }
                    } finally {
                        AppMethodBeat.o(181726);
                    }
                }
            }
        });
        AppMethodBeat.o(181756);
    }

    private void a(a aVar, boolean z) {
        AppMethodBeat.i(181757);
        if (aVar == null) {
            AppMethodBeat.o(181757);
        } else if (aVar.getType() == 1) {
            int alJ = com.tencent.mm.plugin.editor.b.alJ(((j) aVar).content);
            if (z) {
                this.qQs = alJ + this.qQs;
                AppMethodBeat.o(181757);
                return;
            }
            this.qQs -= alJ;
            AppMethodBeat.o(181757);
        } else if (z) {
            this.qQt++;
            AppMethodBeat.o(181757);
        } else {
            this.qQt--;
            AppMethodBeat.o(181757);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010e, code lost:
        if (r2 == -1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0112, code lost:
        if (r10.qQp == null) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0114, code lost:
        r10.qQp.fu(r2, r10.mDataList.size() - r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0120, code lost:
        cDy();
        com.tencent.matrix.trace.core.AppMethodBeat.o(181758);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fx(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.c.fx(int, int):void");
    }

    public final int cDz() {
        AppMethodBeat.i(181759);
        synchronized (this) {
            try {
                if (this.mDataList == null) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.mDataList.size(); i2++) {
                    a aVar = this.mDataList.get(i2);
                    if (aVar != null && aVar.getType() != -3 && aVar.getType() != -2) {
                        AppMethodBeat.o(181759);
                        return i2;
                    }
                }
                AppMethodBeat.o(181759);
                return -1;
            } finally {
                AppMethodBeat.o(181759);
            }
        }
    }

    public final int cDA() {
        AppMethodBeat.i(181760);
        synchronized (this) {
            try {
                if (this.mDataList == null) {
                    return -1;
                }
                for (int size = this.mDataList.size() - 1; size >= 0; size--) {
                    a aVar = this.mDataList.get(size);
                    if (aVar != null && aVar.getType() != -3 && aVar.getType() != -2) {
                        AppMethodBeat.o(181760);
                        return size;
                    }
                }
                AppMethodBeat.o(181760);
                return -1;
            } finally {
                AppMethodBeat.o(181760);
            }
        }
    }
}
