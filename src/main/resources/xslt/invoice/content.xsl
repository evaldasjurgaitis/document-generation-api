<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:java="http://xml.apache.org/xslt/java" exclude-result-prefixes="java"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template name="body" match="/*">
        <fo:flow flow-name="xsl-region-body">
            <fo:table margin-top="30pt" table-layout="fixed" width="94%">
                <fo:table-column column-width="64%"/>
                <fo:table-column column-width="15%"/>
                <fo:table-column column-width="15%"/>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="left">
                                <fo:block>Rechnungs-Nr</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="right">
                                <xsl:value-of select="//invoice/invoiceNo/text()"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="left">
                                <fo:block>Kunded-Nr</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="right">
                                <xsl:value-of select="//invoice/customerNo/text()"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="left">
                                <fo:block>Ust.-Ident-Nr.</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="right">
                                <xsl:value-of select="//invoice/vatIdNo/text()"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="left">
                                <fo:block>Datum</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px" text-align="right">
                                <xsl:value-of select="//invoice/date/text()"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:table margin-top="20pt" table-layout="fixed" width="94.3%">
                <fo:table-column column-width="5%"/>
                <fo:table-column column-width="59%"/>
                <fo:table-column column-width="15%"/>
                <fo:table-column column-width="15%"/>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="12pt" font-family="Bold" font-weight="bold">
                                Rechnung
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8pt" text-align="left">
                                <fo:block>Seite</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8pt" text-align="right">
                                <fo:block>1</fo:block>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:table margin-top="10pt" margin-left="25pt" border-collapse="separate" border-spacing="0pt 3pt"
                      table-layout="fixed" width="94%">
                <fo:table-column column-width="4%"/>
                <fo:table-column column-width="5%"/>
                <fo:table-column column-width="10%"/>
                <fo:table-column column-width="27%"/>
                <fo:table-column column-width="9%"/>
                <fo:table-column column-width="8%"/>
                <fo:table-column column-width="7%"/>
                <fo:table-column column-width="10%"/>
                <fo:table-column column-width="10%"/>
                <fo:table-body start-indent="0">
                    <fo:table-row font-size="8pt" border="1pt solid black" background-color="#8c8f88" text-align="left">
                        <fo:table-cell>
                            <fo:block>
                                Pos
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                KZ
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Artikel-Nr
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Bezeichnung
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Menge
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Einh.
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                MwSt
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Preis
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                Gessamt
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <xsl:for-each select="//invoice/cars">
                        <fo:table-row font-size="8pt" text-align="left">
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="position()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="kz/text()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="referenceNo/text()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="vin/text()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="count/text()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="monotonic/text()"/>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block>
                                    <xsl:value-of select="formattedVat/text()"/> %
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block text-align="right">
                                    <xsl:value-of select="formattedPriceWithoutVat/text()"/> €
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block text-align="right">
                                    <xsl:value-of select="formattedPriceWithVat/text()"/> €
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </xsl:for-each>
                </fo:table-body>
            </fo:table>

            <fo:table margin-top="50pt" margin-left="25pt" table-layout="fixed" width="94.3%">
                <fo:table-column column-width="45.5%"/>
                <fo:table-column column-width="17.8%"/>
                <fo:table-column column-width="15.5%"/>
                <fo:table-column column-width="15.5%"/>
                <fo:table-body start-indent="0" end-indent="0">
                    <fo:table-row font-size="10pt" text-align="left">
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="//invoice/count/text()"/>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="//invoice/amountVat/text()"/> %
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block text-align="left">
                                <xsl:value-of select="//invoice/amountWithoutVat/text()"/> €
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:table margin-top="10pt" margin-left="25pt" table-layout="fixed" width="95%">
                <fo:table-column column-width="49%"/>
                <fo:table-column column-width="29.2%"/>
                <fo:table-column column-width="5.8%"/>
                <fo:table-body start-indent="0" end-indent="0">
                    <fo:table-row font-size="8pt">
                        <fo:table-cell>
                            <fo:block text-align="right">
                                Netto
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block margin-left="30pt" text-align="center">
                                MwSt.
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block text-align="left">
                                Brutto
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:table margin-top="5pt" margin-left="25pt" table-layout="fixed" width="93%">
                <fo:table-column column-width="10%"/>
                <fo:table-column column-width="36%"/>
                <fo:table-column column-width="20%"/>
                <fo:table-column column-width="14%"/>
                <fo:table-column column-width="14%"/>
                <fo:table-body start-indent="0" end-indent="0">
                    <fo:table-row font-size="8pt" text-align="left">
                        <fo:table-cell>
                            <fo:block>
                                Rechnungsbetrag
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="//invoice/amountWithVat/text()"/> EUR
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                0.00 EUR
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block text-align="left">
                                <xsl:value-of select="//invoice/amountWithoutVat/text()"/> EUR
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:block margin-top="5pt" font-size="8pt" margin-left="25pt" text-align="left">
                Menhrwersteuerusätze
            </fo:block>

            <fo:table margin-top="5pt" margin-left="25pt" table-layout="fixed" width="91%">
                <fo:table-column column-width="5%"/>
                <fo:table-column column-width="40%"/>
                <fo:table-column column-width="18%"/>
                <fo:table-column column-width="19%"/>
                <fo:table-column column-width="10%"/>
                <fo:table-body start-indent="0" end-indent="0" border-top-width="0pt" border-bottom-width="1pt"
                               border-right-width="0pt" border-left-width="0pt" border-style="solid"
                               border-color="black">
                    <fo:table-row font-size="8pt" text-align="left">
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                0) Differenzsteuer § 25a MWSt Gesetz
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="//invoice/amountVat/text()"/> % Nettobetrag
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                                <xsl:value-of select="//invoice/amountWithoutVat/text()"/> EUR MwSt.
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block text-align="left">
                                0.00 EUR
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:block margin-top="5pt" margin-left="12pt">
                <fo:inline-container inline-progression-dimension="88.5%">
                    <fo:block border-bottom="1pt solid black"/>
                </fo:inline-container>
            </fo:block>
            <fo:block margin-top="15pt" margin-left="12pt">
                <fo:inline-container inline-progression-dimension="88.5%">
                    <fo:block border-bottom="1pt solid black"/>
                </fo:inline-container>
            </fo:block>
        </fo:flow>
    </xsl:template>
</xsl:stylesheet>