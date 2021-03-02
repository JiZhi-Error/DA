package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class HttpClientUploadWrapper extends HttpWrapperBase {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private static final int CHUNK_LEN = 1024;
    private static final String FIX = "--";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String NEW_LINE = "\r\n";
    private static final String TAG = "MicroMsg.HttpClientWrapper";
    private HttpClient client;
    private HttpPost post;

    static {
        AppMethodBeat.i(230273);
        AppMethodBeat.o(230273);
    }

    public HttpClientUploadWrapper(HttpClient httpClient) {
        this.client = httpClient;
    }

    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    public void send(HttpWrapperBase.Request request, HttpWrapperBase.Response response) {
        int i2 = 0;
        AppMethodBeat.i(230269);
        Log.d(TAG, "request: %s", request);
        try {
            FileUploadEntity fileUploadEntity = new FileUploadEntity(genPrePart(request), request.attachment.filePath, genNextPart(request));
            this.post = new HttpPost(request.getUrl());
            this.post.setHeader("User-Agent", "weixin/android");
            this.post.setHeader("Host", request.host);
            this.post.setHeader("Connection", "Keep-Alive");
            this.post.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.post.setHeader("Cookie", getCookie(request.cookie));
            this.post.setEntity(fileUploadEntity);
            HttpResponse execute = this.client.execute(this.post);
            i2 = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            String value = execute.getFirstHeader("set-cookie").getValue();
            String entityUtils = EntityUtils.toString(entity);
            response.status = i2;
            response.cookie = parseCookie(value);
            response.content = entityUtils;
            Log.d(TAG, "response: %s", response);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            if (i2 == 0) {
                i2 = 503;
            }
            response.status = i2;
        } finally {
            this.client.getConnectionManager().shutdown();
            AppMethodBeat.o(230269);
        }
    }

    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    public void cancel() {
        AppMethodBeat.i(230270);
        Log.d(TAG, "cancel conection.");
        if (this.post != null && !this.post.isAborted()) {
            this.post.abort();
        }
        this.client.getConnectionManager().shutdown();
        AppMethodBeat.o(230270);
    }

    private String genPrePart(HttpWrapperBase.Request request) {
        AppMethodBeat.i(230271);
        StringBuilder sb = new StringBuilder();
        for (String str : request.params.keySet()) {
            sb.append("------" + BOUNDARY + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
            sb.append("\r\n");
            sb.append(request.params.get(str));
            sb.append("\r\n");
        }
        o oVar = new o(request.attachment.filePath);
        if (!oVar.isFile()) {
            InvalidParameterException invalidParameterException = new InvalidParameterException("The path to upload isnot a file.");
            AppMethodBeat.o(230271);
            throw invalidParameterException;
        }
        String name = oVar.getName();
        sb.append("------" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + request.attachment.param + "\"; filename=\"" + name + "\"\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(230271);
        return sb2;
    }

    private String genNextPart(HttpWrapperBase.Request request) {
        AppMethodBeat.i(230272);
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n");
        sb.append("------" + BOUNDARY + "--\r\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(230272);
        return sb2;
    }

    class FileUploadEntity implements HttpEntity {
        private o file;
        private int length;
        private String nextPart;
        private String prePart;

        public FileUploadEntity(String str, String str2, String str3) {
            AppMethodBeat.i(230262);
            this.prePart = str;
            this.file = new o(str2);
            this.nextPart = str3;
            this.length = str.length() + ((int) this.file.length()) + str3.length();
            AppMethodBeat.o(230262);
        }

        public boolean isRepeatable() {
            return true;
        }

        public boolean isChunked() {
            AppMethodBeat.i(230263);
            if (!isRepeatable()) {
                AppMethodBeat.o(230263);
                return true;
            }
            AppMethodBeat.o(230263);
            return false;
        }

        public boolean isStreaming() {
            AppMethodBeat.i(230264);
            if (!isRepeatable()) {
                AppMethodBeat.o(230264);
                return true;
            }
            AppMethodBeat.o(230264);
            return false;
        }

        public long getContentLength() {
            return (long) this.length;
        }

        public Header getContentType() {
            AppMethodBeat.i(230265);
            BasicHeader basicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + HttpClientUploadWrapper.BOUNDARY);
            AppMethodBeat.o(230265);
            return basicHeader;
        }

        public Header getContentEncoding() {
            return null;
        }

        public InputStream getContent() {
            AppMethodBeat.i(230266);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
            AppMethodBeat.o(230266);
            throw unsupportedOperationException;
        }

        public void writeTo(OutputStream outputStream) {
            AppMethodBeat.i(230267);
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
                AppMethodBeat.o(230267);
            } catch (Throwable th) {
                if (0 != 0) {
                    inputStream.close();
                }
                AppMethodBeat.o(230267);
                throw th;
            }
        }

        public void consumeContent() {
            AppMethodBeat.i(230268);
            if (isStreaming()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
                AppMethodBeat.o(230268);
                throw unsupportedOperationException;
            }
            AppMethodBeat.o(230268);
        }
    }
}
