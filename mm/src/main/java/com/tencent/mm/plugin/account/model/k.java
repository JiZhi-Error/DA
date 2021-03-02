package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.h.a.a;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.e;
import com.tencent.mm.ui.h.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k {
    MMHandler handler;
    private c kiu;
    a kiv;

    public interface a {
        void E(Bundle bundle);

        void onError(int i2, String str);
    }

    public k(c cVar, a aVar) {
        this.kiu = cVar;
        this.kiv = aVar;
    }

    public final void bnw() {
        AppMethodBeat.i(127846);
        this.handler = new MMHandler() {
            /* class com.tencent.mm.plugin.account.model.k.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(127841);
                switch (message.what) {
                    case 1:
                        if (k.this.kiv != null) {
                            k.this.kiv.onError(message.arg1, (String) message.obj);
                            AppMethodBeat.o(127841);
                            return;
                        }
                        break;
                    case 2:
                        if (k.this.kiv != null) {
                            k.this.kiv.E(message.getData());
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(127841);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("client_id", MMApplicationContext.getContext().getString(R.string.c71));
        bundle.putString("client_secret", MMApplicationContext.getContext().getString(R.string.c7f));
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.kiu.jZX);
        ThreadPool.post(new Runnable("oauth/access_token", bundle, "GET", new a.AbstractC2117a() {
            /* class com.tencent.mm.plugin.account.model.k.AnonymousClass2 */

            @Override // com.tencent.mm.ui.h.a.a.AbstractC2117a
            public final void Tn(String str) {
                AppMethodBeat.i(127842);
                if (str == null || str.length() == 0) {
                    Log.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
                    k.a(k.this, 1, "response is null or nil");
                    AppMethodBeat.o(127842);
                } else if (!str.contains("access_token") || str.length() <= 12) {
                    try {
                        f.bnI(str);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e2.getMessage());
                        Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                    } catch (e e3) {
                        String str2 = "errCode = " + e3.mErrorCode + ", errType = " + e3.QjS + ", errMsg = " + e3.getMessage();
                        Log.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(str2)));
                        Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", e3, "", new Object[0]);
                        k.a(k.this, 3, str2);
                        AppMethodBeat.o(127842);
                        return;
                    }
                    k.a(k.this, 2, "parseJson error");
                    AppMethodBeat.o(127842);
                } else {
                    try {
                        JSONObject bnI = f.bnI(str);
                        if (bnI.has("access_token")) {
                            Bundle bundle = new Bundle();
                            Iterator<String> keys = bnI.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONArray optJSONArray = bnI.optJSONArray(next);
                                Double valueOf = Double.valueOf(bnI.optDouble(next));
                                String optString = bnI.optString(next);
                                if (optJSONArray != null && optJSONArray.length() <= 0) {
                                    bundle.putStringArray(next, new String[0]);
                                } else if (optJSONArray != null && !Double.isNaN(optJSONArray.optDouble(0))) {
                                    double[] dArr = new double[optJSONArray.length()];
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        dArr[i2] = optJSONArray.optDouble(i2);
                                    }
                                    bundle.putDoubleArray(next, dArr);
                                } else if (optJSONArray != null && optJSONArray.optString(0) != null) {
                                    String[] strArr = new String[optJSONArray.length()];
                                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                        strArr[i3] = optJSONArray.optString(i3);
                                    }
                                    bundle.putStringArray(next, strArr);
                                } else if (!valueOf.isNaN()) {
                                    bundle.putDouble(next, valueOf.doubleValue());
                                } else if (optString != null) {
                                    bundle.putString(next, optString);
                                } else {
                                    System.err.println("unable to transform json to bundle ".concat(String.valueOf(next)));
                                }
                            }
                            k kVar = k.this;
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.setData(bundle);
                            kVar.handler.sendMessage(obtain);
                            AppMethodBeat.o(127842);
                            return;
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.RefreshTokenRunner", th, "", new Object[0]);
                    }
                    k.a(k.this, 2, "decodeUrl fail");
                    AppMethodBeat.o(127842);
                }
            }

            @Override // com.tencent.mm.ui.h.a.a.AbstractC2117a
            public final void c(IOException iOException) {
                AppMethodBeat.i(127843);
                Log.e("MicroMsg.RefreshTokenRunner", "onIOException");
                k.a(k.this, 2, iOException.getMessage());
                AppMethodBeat.o(127843);
            }

            @Override // com.tencent.mm.ui.h.a.a.AbstractC2117a
            public final void a(FileNotFoundException fileNotFoundException) {
                AppMethodBeat.i(127844);
                Log.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
                k.a(k.this, 2, fileNotFoundException.getMessage());
                AppMethodBeat.o(127844);
            }

            @Override // com.tencent.mm.ui.h.a.a.AbstractC2117a
            public final void a(MalformedURLException malformedURLException) {
                AppMethodBeat.i(127845);
                Log.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
                k.a(k.this, 2, malformedURLException.getMessage());
                AppMethodBeat.o(127845);
            }
        }) {
            /* class com.tencent.mm.ui.h.a.a.AnonymousClass1 */
            final /* synthetic */ String Qjv;
            final /* synthetic */ String Qjw;
            final /* synthetic */ AbstractC2117a Qjx;
            final /* synthetic */ Object Qjy = null;
            final /* synthetic */ Bundle val$parameters;

            {
                this.Qjv = r3;
                this.val$parameters = r4;
                this.Qjw = r5;
                this.Qjx = r6;
            }

            public final void run() {
                AppMethodBeat.i(152805);
                try {
                    this.Qjx.Tn(a.this.Qju.a(this.Qjv, this.val$parameters, this.Qjw));
                    AppMethodBeat.o(152805);
                } catch (FileNotFoundException e2) {
                    this.Qjx.a(e2);
                    AppMethodBeat.o(152805);
                } catch (MalformedURLException e3) {
                    this.Qjx.a(e3);
                    AppMethodBeat.o(152805);
                } catch (IOException e4) {
                    this.Qjx.c(e4);
                    AppMethodBeat.o(152805);
                }
            }
        }, "AsyncFacebookRunner_request");
        AppMethodBeat.o(127846);
    }

    static /* synthetic */ void a(k kVar, int i2, String str) {
        AppMethodBeat.i(127847);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i2;
        obtain.obj = str;
        kVar.handler.sendMessage(obtain);
        AppMethodBeat.o(127847);
    }
}
