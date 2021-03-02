package com.tencent.mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.WebResourceResponse;
import com.tencent.f.h;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class LuggageMMLocalResourceProvider implements c {
    @Override // com.tencent.luggage.webview.a.c
    public final String Pl() {
        return "weixin://resourceid/.*";
    }

    @Override // com.tencent.luggage.webview.a.c
    public final WebResourceResponse cX(String str) {
        AppMethodBeat.i(78221);
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        try {
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            final GetLocalResourceInfoTask getLocalResourceInfoTask = new GetLocalResourceInfoTask((byte) 0);
            getLocalResourceInfoTask.dJX = str;
            getLocalResourceInfoTask.infoType = 1;
            getLocalResourceInfoTask.mpO = new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(78214);
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(78213);
                            InputStream inputStream = null;
                            try {
                                InputStream openRead = s.openRead(getLocalResourceInfoTask.path);
                                PipedOutputStream pipedOutputStream = pipedOutputStream;
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = openRead.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    pipedOutputStream.write(bArr, 0, read);
                                }
                                if (openRead != null) {
                                    try {
                                        openRead.close();
                                    } catch (Exception e2) {
                                        AppMethodBeat.o(78213);
                                        return;
                                    }
                                }
                                pipedOutputStream.close();
                                AppMethodBeat.o(78213);
                            } catch (Exception e3) {
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        AppMethodBeat.o(78213);
                                        return;
                                    }
                                }
                                pipedOutputStream.close();
                                AppMethodBeat.o(78213);
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                        AppMethodBeat.o(78213);
                                        throw th;
                                    }
                                }
                                pipedOutputStream.close();
                                AppMethodBeat.o(78213);
                                throw th;
                            }
                        }
                    });
                    AppMethodBeat.o(78214);
                }
            };
            AppBrandMainProcessService.a(getLocalResourceInfoTask);
            WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, pipedInputStream);
            AppMethodBeat.o(78221);
            return webResourceResponse;
        } catch (Exception e2) {
            AppMethodBeat.o(78221);
            return null;
        }
    }

    static class GetLocalResourceInfoTask extends MainProcessTask {
        public static final Parcelable.Creator<GetLocalResourceInfoTask> CREATOR = new Parcelable.Creator<GetLocalResourceInfoTask>() {
            /* class com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.GetLocalResourceInfoTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetLocalResourceInfoTask[] newArray(int i2) {
                return new GetLocalResourceInfoTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetLocalResourceInfoTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(78215);
                GetLocalResourceInfoTask getLocalResourceInfoTask = new GetLocalResourceInfoTask((byte) 0);
                getLocalResourceInfoTask.f(parcel);
                AppMethodBeat.o(78215);
                return getLocalResourceInfoTask;
            }
        };
        String dJX;
        int infoType;
        Runnable mpO;
        String path;

        private GetLocalResourceInfoTask() {
        }

        /* synthetic */ GetLocalResourceInfoTask(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(78216);
            switch (this.infoType) {
                case 1:
                    this.path = ay.aYZ(this.dJX);
                    break;
                case 2:
                    this.path = ay.aZa(this.dJX);
                    break;
            }
            bDU();
            AppMethodBeat.o(78216);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(78217);
            if (this.mpO != null) {
                this.mpO.run();
            }
            AppMethodBeat.o(78217);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(78218);
            parcel.writeString(this.dJX);
            parcel.writeInt(this.infoType);
            parcel.writeString(this.path);
            AppMethodBeat.o(78218);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(78219);
            this.dJX = parcel.readString();
            this.infoType = parcel.readInt();
            this.path = parcel.readString();
            AppMethodBeat.o(78219);
        }

        static {
            AppMethodBeat.i(78220);
            AppMethodBeat.o(78220);
        }
    }
}
