<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:java="http://xml.apache.org/xslt/java" exclude-result-prefixes="java"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                xmlns:fox="http://xmlgraphics.apache.org/fop/extensions">
    <xsl:include href="layout/LayoutInfoDeclaration.xsl"/>
    <xsl:include href="invoice/headerAndFooter.xsl"/>
    <xsl:include href="invoice/content.xsl"/>
    <xsl:template name="creditInvoice" match="/*">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" font-family="Arial, Bold">
            <xsl:call-template name="declarationAndLayout"/>
            <fo:page-sequence master-reference="invoice">
                <xsl:call-template name="headerAndFooter"/>
                <xsl:call-template name="body"/>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>