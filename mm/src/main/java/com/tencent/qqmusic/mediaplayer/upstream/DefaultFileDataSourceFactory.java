package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultFileDataSourceFactory implements IDataSourceFactory {
    private final String filePath;

    public DefaultFileDataSourceFactory(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    public IDataSource createDataSource() {
        AppMethodBeat.i(114296);
        if (TextUtils.isEmpty(this.filePath)) {
            DataSourceException dataSourceException = new DataSourceException(-5, "filePath is empty!", null);
            AppMethodBeat.o(114296);
            throw dataSourceException;
        }
        FileDataSource fileDataSource = new FileDataSource(this.filePath);
        AppMethodBeat.o(114296);
        return fileDataSource;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    public INativeDataSource createNativeDataSource() {
        AppMethodBeat.i(114297);
        INativeDataSource fileDataSource = NativeDataSourceFactory.fileDataSource(this.filePath, 0);
        AppMethodBeat.o(114297);
        return fileDataSource;
    }
}
