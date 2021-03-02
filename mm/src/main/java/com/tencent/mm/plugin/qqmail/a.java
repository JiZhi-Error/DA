package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public final class a extends c {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost post;

    static {
        AppMethodBeat.i(198560);
        AppMethodBeat.o(198560);
    }

    @Override // com.tencent.mm.plugin.qqmail.c
    public final c.f a(String str, String str2, c.e eVar, c.d dVar) {
        c.f fVar;
        int i2 = 0;
        AppMethodBeat.i(198557);
        Log.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + eVar);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a2 = a(eVar);
            String str3 = eVar.BqS.filePath;
            StringBuilder sb = new StringBuilder();
            sb.append(APLogFileUtil.SEPARATOR_LINE);
            sb.append("------" + BOUNDARY + "--\r\n");
            C1610a aVar = new C1610a(a2, str3, sb.toString());
            this.post = new HttpPost(d(str, str2, eVar.params));
            this.post.setHeader("User-Agent", USER_AGENT);
            this.post.setHeader("Host", host);
            this.post.setHeader("Connection", "Keep-Alive");
            this.post.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.post.setHeader("Cookie", getCookie(eVar.cookie));
            this.post.setEntity(aVar);
            HttpResponse execute = defaultHttpClient.execute(this.post);
            i2 = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            String value = execute.getFirstHeader("set-cookie").getValue();
            fVar = new c.f(i2, parseCookie(value), EntityUtils.toString(entity));
            Log.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + fVar);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.HttpClientUtil", e2, "", new Object[0]);
            if (i2 == 0) {
                i2 = 503;
            }
            fVar = new c.f(i2, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
            AppMethodBeat.o(198557);
        }
        return fVar;
    }

    @Override // com.tencent.mm.plugin.qqmail.c
    public final void cancel() {
        AppMethodBeat.i(198558);
        Log.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (this.post != null && !this.post.isAborted()) {
            this.post.abort();
        }
        AppMethodBeat.o(198558);
    }

    private static String a(c.e eVar) {
        AppMethodBeat.i(198559);
        StringBuilder sb = new StringBuilder();
        for (String str : eVar.params.keySet()) {
            sb.append("------" + BOUNDARY + APLogFileUtil.SEPARATOR_LINE);
            sb.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
            sb.append(APLogFileUtil.SEPARATOR_LINE);
            sb.append(eVar.params.get(str));
            sb.append(APLogFileUtil.SEPARATOR_LINE);
        }
        o oVar = new o(eVar.BqS.filePath);
        if (!oVar.isFile()) {
            InvalidParameterException invalidParameterException = new InvalidParameterException("The path to upload isnot a file.");
            AppMethodBeat.o(198559);
            throw invalidParameterException;
        }
        String name = oVar.getName();
        sb.append("------" + BOUNDARY + APLogFileUtil.SEPARATOR_LINE);
        sb.append("Content-Disposition: form-data; name=\"" + eVar.BqS.param + "\"; filename=\"" + name + "\"\r\n");
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        String sb2 = sb.toString();
        AppMethodBeat.o(198559);
        return sb2;
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.a$a  reason: collision with other inner class name */
    class C1610a implements HttpEntity {
        private o file;
        private int length;
        private String nextPart;
        private String prePart;

        public C1610a(String str, String str2, String str3) {
            AppMethodBeat.i(198550);
            this.prePart = str;
            this.file = new o(str2);
            this.nextPart = str3;
            this.length = str.length() + ((int) this.file.length()) + str3.length();
            AppMethodBeat.o(198550);
        }

        public final boolean isRepeatable() {
            return true;
        }

        public final boolean isChunked() {
            AppMethodBeat.i(198551);
            if (!isRepeatable()) {
                AppMethodBeat.o(198551);
                return true;
            }
            AppMethodBeat.o(198551);
            return false;
        }

        public final boolean isStreaming() {
            AppMethodBeat.i(198552);
            if (!isRepeatable()) {
                AppMethodBeat.o(198552);
                return true;
            }
            AppMethodBeat.o(198552);
            return false;
        }

        public final long getContentLength() {
            return (long) this.length;
        }

        public final Header getContentType() {
            AppMethodBeat.i(198553);
            BasicHeader basicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + a.BOUNDARY);
            AppMethodBeat.o(198553);
            return basicHeader;
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final InputStream getContent() {
            AppMethodBeat.i(198554);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
            AppMethodBeat.o(198554);
            throw unsupportedOperationException;
        }

        public final void writeTo(OutputStream outputStream) {
            AppMethodBeat.i(198555);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(this.prePart);
            InputStream inputStream = null;
            try {
                byte[] bArr = new byte[1024];
                InputStream ao = s.ao(this.file);
                while (true) {
                    int read = ao.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                dataOutputStream.flush();
                if (ao != null) {
                    ao.close();
                }
                dataOutputStream.writeBytes(this.nextPart);
                AppMethodBeat.o(198555);
            } catch (Throwable th) {
                if (0 != 0) {
                    inputStream.close();
                }
                AppMethodBeat.o(198555);
                throw th;
            }
        }

        public final void consumeContent() {
            AppMethodBeat.i(198556);
            if (isStreaming()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
                AppMethodBeat.o(198556);
                throw unsupportedOperationException;
            }
            AppMethodBeat.o(198556);
        }
    }
}
