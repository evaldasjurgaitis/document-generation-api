<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:java="http://xml.apache.org/xslt/java" exclude-result-prefixes="java"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template name="declarationAndLayout" match="/*">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="invoice" page-height="11.7in" page-width="8.3in" margin-top="0.5in"
                                   margin-left="0.5in" margin-right="0.5in" margin-bottom="0.5in">
                <fo:region-body margin-top="3.5in"/>
                <fo:region-before/>
                <fo:region-after extent="0.5in"/>
            </fo:simple-page-master>
        </fo:layout-master-set>
    </xsl:template>
</xsl:stylesheet>
