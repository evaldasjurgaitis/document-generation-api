<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:java="http://xml.apache.org/xslt/java" exclude-result-prefixes="java"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template name="headerAndFooter" match="/*">
        <fo:static-content flow-name="xsl-region-before">
            <fo:block>
                <fo:inline-container inline-progression-dimension="100%">
                    <fo:block>
                        <fo:external-graphic content-height="3.42cm"
                                             src="src/main/resources/images/logo.png"/>
                    </fo:block>
                </fo:inline-container>
            </fo:block>

            <fo:table border-collapse="separate" border-separation="3mm" table-layout="fixed" width="100%">
                <fo:table-column column-width="52%"/>
                <fo:table-column column-width="16%"/>
                <fo:table-column column-width="32%"/>
                <fo:table-body font-size="8pt">
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block border-top-width="0pt" border-bottom-width="1pt"
                                      border-right-width="0pt" border-left-width="0pt" border-style="solid"
                                      border-color="black">
                                <fo:block font-size="7.7px">
                                    Autoverwertung Kerstingjohänner GmbH Heileforthstr. 93 33758 Schloß Holte
                                </fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="11px" border-top-width="0pt" border-bottom-width="1pt"
                                      border-right-width="0pt" border-left-width="0pt" border-style="solid"
                                      border-color="black" text-align="center" padding-bottom="5pt">
                                <fo:block>PKW + LKW An - und Verkauf</fo:block>
                                <fo:block>Verwertung und Entsorgung</fo:block>
                                <fo:block>Reifendienst Ersatzteilhandel</fo:block>
                                <fo:block>KFZ-Meisterbetrieb</fo:block>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>

            <fo:table table-layout="fixed" width="100%">
                <fo:table-column column-width="5%"/>
                <fo:table-column column-width="47%"/>
                <fo:table-column column-width="16%"/>
                <fo:table-column column-width="32%"/>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="8px">
                                <fo:block>Realschule Augustdorf</fo:block>
                                <fo:block>Akazienstr. 11</fo:block>
                                <fo:block font-family="Bold" font-weight="bold">D 32832 Augustdrof</fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block>
                            </fo:block>
                        </fo:table-cell>
                        <fo:table-cell>
                            <fo:block font-size="11px" text-align="center" padding-top="10pt">
                                <fo:block font-size="12px" font-family="Bold" font-weight="bold">
                                    <fo:inline-container inline-progression-dimension="20%">
                                        <fo:block text-align="left">
                                            Tel:
                                        </fo:block>
                                    </fo:inline-container>
                                    <fo:inline-container inline-progression-dimension="80%">
                                        <fo:block text-align="right">
                                            +49 5207 9105-0
                                        </fo:block>
                                    </fo:inline-container>
                                </fo:block>
                                <fo:block>
                                    <fo:inline-container inline-progression-dimension="20%">
                                        <fo:block text-align="left">
                                            Fax:
                                        </fo:block>
                                    </fo:inline-container>
                                    <fo:inline-container inline-progression-dimension="80%">
                                        <fo:block text-align="right">
                                            +49 5207 9105-99
                                        </fo:block>
                                    </fo:inline-container>
                                </fo:block>
                                <fo:block>
                                    <fo:inline-container inline-progression-dimension="20%">
                                        <fo:block text-align="left">
                                            mail:
                                        </fo:block>
                                    </fo:inline-container>
                                    <fo:inline-container inline-progression-dimension="80%">
                                        <fo:block text-align="right">
                                            mail@avwk.de
                                        </fo:block>
                                    </fo:inline-container>
                                </fo:block>
                                <fo:block>
                                    <fo:inline-container inline-progression-dimension="20%">
                                        <fo:block text-align="left">
                                            web:
                                        </fo:block>
                                    </fo:inline-container>
                                    <fo:inline-container inline-progression-dimension="80%">
                                        <fo:block text-align="right">
                                            www.avwk.de
                                        </fo:block>
                                    </fo:inline-container>
                                </fo:block>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:static-content>

        <fo:static-content flow-name="xsl-region-after">
            <fo:block>
                <fo:inline-container inline-progression-dimension="28%" vertical-align="middle">
                    <fo:block font-size="7px" border-top-width="0pt" border-bottom-width="0pt"
                              border-right-width="1pt" border-left-width="0pt" border-style="solid"
                              border-color="grey" padding-top="4pt" padding-bottom="4pt" margin-right="6pt">
                        <fo:block>Autoverwertung Kerstingjohänner GmbH</fo:block>
                        <fo:block>Helleforthstr. 93 33758 Schloß Holte-Stk.</fo:block>
                        <fo:block>Geschäftsführer: Thomas Kerstingjohänner</fo:block>
                    </fo:block>
                </fo:inline-container>
                <fo:inline-container inline-progression-dimension="24%" vertical-align="middle">
                    <fo:block font-size="7px" border-top-width="0pt" border-bottom-width="0pt"
                              border-right-width="1pt" border-left-width="0pt" border-style="solid"
                              border-color="grey" padding-top="4pt" padding-bottom="4pt" margin-right="6pt">
                        <fo:block>Handelsregister Bielefeld HRB 34115</fo:block>
                        <fo:block>Steuer-Nr. 347 / 5845 / 3024</fo:block>
                        <fo:block>USt. -Ident-Nr. DE811321521</fo:block>
                    </fo:block>
                </fo:inline-container>
                <fo:inline-container inline-progression-dimension="24%" vertical-align="middle">
                    <fo:block font-size="7px" border-top-width="0pt" border-bottom-width="0pt"
                              border-right-width="1pt" border-left-width="0pt" border-style="solid"
                              border-color="grey" padding-top="4pt" padding-bottom="4pt" margin-right="6pt">
                        <fo:block>Volksbank Bielefeld-Gütersloh eG</fo:block>
                        <fo:block>BIC: GENODEM1GTL</fo:block>
                        <fo:block>IBAN: DE38 4786 0125 0087 3370 01</fo:block>
                    </fo:block>
                </fo:inline-container>
                <fo:inline-container inline-progression-dimension="24%" vertical-align="middle">
                    <fo:block font-size="7px" padding-top="4pt" padding-bottom="4pt">
                        <fo:block>Kreissparkasses Wiedenbrück</fo:block>
                        <fo:block>BIC: WELADED1WDB</fo:block>
                        <fo:block>IBAN: DE60 4785 3520 0052 0030 50</fo:block>
                    </fo:block>
                </fo:inline-container>
            </fo:block>
        </fo:static-content>
    </xsl:template>
</xsl:stylesheet>