package org.xframium.artifact.spi;

import java.io.File;
import java.io.InputStream;
import org.xframium.artifact.AbstractArtifact;
import org.xframium.artifact.ArtifactType;
import org.xframium.device.factory.DeviceWebDriver;

public class DefaultHistoryReportingArtifact extends AbstractArtifact
{
    private static final String FILE_NAME = "index.html";
    public DefaultHistoryReportingArtifact()
    {
        setArtifactType( ArtifactType.EXECUTION_HISTORY_HTML.name() );
    }
    
    @Override
    protected File _generateArtifact( File rootFolder, DeviceWebDriver webDriver, String xFID )
    {
        InputStream inputStream = null;
        try
        {
            inputStream = getTemplate( "History.html" );
            return writeToDisk( rootFolder, FILE_NAME, inputStream );
        }
        catch( Exception e )
        {
            log.error( "Error generating HTML", e );
            return null;
        }
        finally
        {
            try { inputStream.close(); } catch( Exception e ) {}
        }
    }
}
