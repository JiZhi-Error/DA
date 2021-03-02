package com.qq.wx.voice.embed.recognizer;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Grammar {
    public static String mData = null;
    public static String mDataPath = null;
    public static String mSo = null;

    /* renamed from: a  reason: collision with root package name */
    private f f112a;

    /* renamed from: b  reason: collision with root package name */
    private a f113b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f114c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f115d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f116e;

    public Grammar() {
        AppMethodBeat.i(76758);
        this.f112a = null;
        this.f113b = new a();
        this.f114c = false;
        this.f115d = false;
        this.f116e = null;
        this.f112a = new f();
        AppMethodBeat.o(76758);
    }

    private String a() {
        AppMethodBeat.i(76762);
        for (int i2 = 0; i2 < this.f116e.size(); i2++) {
            ((d) this.f116e.get(i2)).cgp = a(((d) this.f116e.get(i2)).userName);
            ((d) this.f116e.get(i2)).cgq = a(((d) this.f116e.get(i2)).nickName);
            ((d) this.f116e.get(i2)).cgr = a(((d) this.f116e.get(i2)).cgo);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i3 = 0; i3 < this.f116e.size(); i3++) {
            String str = ((d) this.f116e.get(i3)).cgp;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            String str2 = ((d) this.f116e.get(i3)).cgq;
            if (!str2.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str2);
            }
            String str3 = ((d) this.f116e.get(i3)).cgr;
            if (!str3.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str3);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76762);
        return stringBuffer2;
    }

    private static String a(String str) {
        AppMethodBeat.i(76763);
        String replaceAll = new String(str).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll(AppEventsConstants.EVENT_PARAM_VALUE_NO, "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
        AppMethodBeat.o(76763);
        return replaceAll;
    }

    public int begin() {
        AppMethodBeat.i(76764);
        int begin = GrammarNative.begin();
        AppMethodBeat.o(76764);
        return begin;
    }

    public int end() {
        AppMethodBeat.i(76766);
        int end = GrammarNative.end();
        AppMethodBeat.o(76766);
        return end;
    }

    public int getResult(a aVar) {
        AppMethodBeat.i(76767);
        int result = GrammarNative.getResult(this);
        if (result < 0) {
            AppMethodBeat.o(76767);
            return result;
        }
        aVar.text = this.f113b.text;
        if (this.f113b.name == null) {
            aVar.name = null;
            AppMethodBeat.o(76767);
            return 0;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f116e.size()) {
                break;
            } else if (((d) this.f116e.get(i2)).cgp.compareTo(this.f113b.name) == 0) {
                aVar.name = ((d) this.f116e.get(i2)).userName;
                break;
            } else if (((d) this.f116e.get(i2)).cgq.compareTo(this.f113b.name) == 0) {
                aVar.name = ((d) this.f116e.get(i2)).userName;
                break;
            } else if (((d) this.f116e.get(i2)).cgr.compareTo(this.f113b.name) == 0) {
                aVar.name = ((d) this.f116e.get(i2)).userName;
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(76767);
        return 0;
    }

    public int init(ArrayList arrayList) {
        AppMethodBeat.i(76760);
        if (this.f115d) {
            AppMethodBeat.o(76760);
            return 0;
        } else if (arrayList == null) {
            AppMethodBeat.o(76760);
            return -303;
        } else {
            try {
                System.load(String.valueOf(mDataPath) + FilePathGenerator.ANDROID_DIR_SEP + mSo);
                this.f116e = arrayList;
                String a2 = a();
                try {
                    if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), a2.toString().getBytes("GBK")) < 0) {
                        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a2);
                        AppMethodBeat.o(76760);
                        return -101;
                    }
                    this.f115d = true;
                    AppMethodBeat.o(76760);
                    return 0;
                } catch (UnsupportedEncodingException e2) {
                    new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a2);
                    AppMethodBeat.o(76760);
                    return -101;
                }
            } catch (Exception e3) {
                AppMethodBeat.o(76760);
                return -205;
            }
        }
    }

    public void onGetResult(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(76768);
        if (bArr != null) {
            try {
                this.f113b.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e2) {
                AppMethodBeat.o(76768);
                return;
            }
        } else {
            this.f113b.text = null;
        }
        if (bArr3 != null) {
            this.f113b.name = new String(bArr3, "GBK");
            AppMethodBeat.o(76768);
            return;
        }
        this.f113b.name = null;
        AppMethodBeat.o(76768);
    }

    public int recognize(byte[] bArr, int i2) {
        AppMethodBeat.i(76765);
        int recognize = GrammarNative.recognize(bArr, i2);
        AppMethodBeat.o(76765);
        return recognize;
    }

    public int update(ArrayList arrayList) {
        AppMethodBeat.i(76761);
        if (arrayList == null) {
            AppMethodBeat.o(76761);
            return -303;
        }
        this.f116e = arrayList;
        try {
            if (GrammarNative.update(a().getBytes("GBK")) < 0) {
                AppMethodBeat.o(76761);
                return -106;
            }
            AppMethodBeat.o(76761);
            return 0;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(76761);
            return -106;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r1 < 0) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int checkFiles(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.wx.voice.embed.recognizer.Grammar.checkFiles(android.content.Context, java.lang.String, java.lang.String, java.lang.String):int");
    }
}
