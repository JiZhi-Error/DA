package io.flutter.plugin.a;

import java.nio.ByteBuffer;

public interface c {

    public interface a {
        void a(ByteBuffer byteBuffer, b bVar);
    }

    public interface b {
        void I(ByteBuffer byteBuffer);
    }

    void a(String str, a aVar);

    void a(String str, ByteBuffer byteBuffer);

    void a(String str, ByteBuffer byteBuffer, b bVar);
}
