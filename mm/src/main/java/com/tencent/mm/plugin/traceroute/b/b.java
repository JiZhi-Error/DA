package com.tencent.mm.plugin.traceroute.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class b {
    public static String aTK(String str) {
        AppMethodBeat.i(29670);
        Log.i("MicroMsg.MMTraceRoute", "output string: ".concat(String.valueOf(str)));
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(29670);
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            AppMethodBeat.o(29670);
            return null;
        }
        int i2 = indexOf + 5;
        int indexOf2 = str.indexOf(" ", i2);
        if (indexOf2 < 0) {
            AppMethodBeat.o(29670);
            return null;
        }
        String substring = str.substring(i2, indexOf2);
        AppMethodBeat.o(29670);
        return substring;
    }

    public static int aTL(String str) {
        AppMethodBeat.i(29671);
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            AppMethodBeat.o(29671);
            return -1;
        }
        int i2 = indexOf + 4;
        int indexOf2 = str.indexOf(" ", i2);
        if (indexOf2 < 0) {
            AppMethodBeat.o(29671);
            return -1;
        }
        int i3 = Util.getInt(str.substring(i2, indexOf2), 0);
        AppMethodBeat.o(29671);
        return i3;
    }

    public static List<Object> S(String[] strArr) {
        AppMethodBeat.i(29672);
        String str = " ";
        for (int i2 = 0; i2 < 4; i2++) {
            str = str + strArr[i2] + " ";
        }
        Log.i("MicroMsg.MMTraceRoute", str);
        ArrayList arrayList = new ArrayList();
        try {
            h.RTc.aX(new a(strArr, arrayList)).get(5000, TimeUnit.MILLISECONDS);
            Log.i("MicroMsg.MMTraceRoute", "watcher thread stopped".concat(String.valueOf(str)));
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
        }
        AppMethodBeat.o(29672);
        return arrayList;
    }

    static class a implements com.tencent.f.i.h {
        private String[] GrB;
        private List<Object> mWl;

        public a(String[] strArr, List<Object> list) {
            this.GrB = strArr;
            this.mWl = list;
        }

        public final void run() {
            BufferedReader bufferedReader;
            Process process;
            Throwable th;
            Exception e2;
            InterruptedException e3;
            AppMethodBeat.i(29669);
            StringBuilder sb = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder(this.GrB);
            processBuilder.redirectErrorStream(true);
            long nowMilliSecond = Util.nowMilliSecond();
            long nowMilliSecond2 = Util.nowMilliSecond();
            try {
                process = processBuilder.start();
                try {
                    Util.qualityClose(process.getOutputStream());
                    nowMilliSecond2 = Util.nowMilliSecond();
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 8096);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                Log.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                                b.a(process, bufferedReader);
                                this.mWl.add(sb.toString());
                                this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                                Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                                AppMethodBeat.o(29669);
                            } catch (Throwable th2) {
                                th = th2;
                                b.a(process, bufferedReader);
                                AppMethodBeat.o(29669);
                                throw th;
                            }
                        } catch (InterruptedException e5) {
                            e3 = e5;
                            Log.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e3.getMessage());
                            b.a(process, bufferedReader);
                            this.mWl.add(sb.toString());
                            this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                            Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                            AppMethodBeat.o(29669);
                        } catch (Exception e6) {
                            e2 = e6;
                            Log.e("MicroMsg.MMTraceRoute", "run cmd err: " + e2.getMessage());
                            b.a(process, bufferedReader);
                            this.mWl.add(sb.toString());
                            this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                            Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                            AppMethodBeat.o(29669);
                        }
                    }
                    process.waitFor();
                    b.a(process, bufferedReader);
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                    Log.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                    b.a(process, bufferedReader);
                    this.mWl.add(sb.toString());
                    this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                    Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                    AppMethodBeat.o(29669);
                } catch (InterruptedException e8) {
                    e3 = e8;
                    bufferedReader = null;
                    Log.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e3.getMessage());
                    b.a(process, bufferedReader);
                    this.mWl.add(sb.toString());
                    this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                    Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                    AppMethodBeat.o(29669);
                } catch (Exception e9) {
                    e2 = e9;
                    bufferedReader = null;
                    Log.e("MicroMsg.MMTraceRoute", "run cmd err: " + e2.getMessage());
                    b.a(process, bufferedReader);
                    this.mWl.add(sb.toString());
                    this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                    Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                    AppMethodBeat.o(29669);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    b.a(process, bufferedReader);
                    AppMethodBeat.o(29669);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
                process = null;
                Log.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                b.a(process, bufferedReader);
                this.mWl.add(sb.toString());
                this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                AppMethodBeat.o(29669);
            } catch (InterruptedException e11) {
                e3 = e11;
                bufferedReader = null;
                process = null;
                Log.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e3.getMessage());
                b.a(process, bufferedReader);
                this.mWl.add(sb.toString());
                this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                AppMethodBeat.o(29669);
            } catch (Exception e12) {
                e2 = e12;
                bufferedReader = null;
                process = null;
                Log.e("MicroMsg.MMTraceRoute", "run cmd err: " + e2.getMessage());
                b.a(process, bufferedReader);
                this.mWl.add(sb.toString());
                this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
                Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
                AppMethodBeat.o(29669);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                process = null;
                b.a(process, bufferedReader);
                AppMethodBeat.o(29669);
                throw th;
            }
            this.mWl.add(sb.toString());
            this.mWl.add(Long.valueOf(nowMilliSecond2 - nowMilliSecond));
            Log.i("MicroMsg.MMTraceRoute", "stringbuilder: " + sb.toString());
            AppMethodBeat.o(29669);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MMTraceRouteCMDExecutor_watcher";
        }
    }

    static /* synthetic */ void a(Process process, BufferedReader bufferedReader) {
        AppMethodBeat.i(29673);
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.MMTraceRoute", th, "close reader failed", new Object[0]);
            }
        }
        if (process != null) {
            try {
                process.destroy();
                AppMethodBeat.o(29673);
                return;
            } catch (Throwable th2) {
                Log.printErrStackTrace("MicroMsg.MMTraceRoute", th2, "destroy process failed", new Object[0]);
            }
        }
        AppMethodBeat.o(29673);
    }
}
