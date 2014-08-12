/* 
 * Author: David Buzatto
 */

$( function() {
    
    $.ajaxPrefilter( "json script", function( options ) {
        options.crossDomain = true;
    });
    
    $( "#colorScheme" ).change( function( evt ) {
        
        var sufix = $( "#colorScheme" ).val();
        
        $( ".divAA" ).each( function( ind, ele ){
            $( ele ).attr( "aaType", $( ele ).html() + "-" + sufix );
        });
        
    });
    
    $.getScript( "data.js", function( d, ts, jqXHR ) {
        
        var $content = $( "#content" );
        var leftStart = 30;
        var lineHeight = 14;
        var idLength;
        var j;
        var count = 1;
        
        for ( var i = 0; i < data.length; i++ ) {
            
            var sec = data[i].sec;
            
            if ( sec !== null ) {
                
                var alnSeq;
                var itemSize = sec.length;
                var first = true;
                
                for ( j = 0; j < itemSize; j++ ) {
                    
                    var item = sec[j];
                    
                    var id = item.id;
                    var seq = item.seq;
                    
                    if ( id !== null ) {
                            
                        if ( id === "aln" ) {
                            alnSeq = seq;
                        } else {
                            
                            var $newDivId = $( "<div><div/>" );
                            $newDivId.addClass( "divId" );
                            $newDivId.html( id );
                            $newDivId.css( "left", leftStart + "px" );
                            $newDivId.css( "top", ( lineHeight * ( j + 2 ) + (itemSize + 3) * lineHeight * i ) + "px" );
                            $content.append( $newDivId );
                            
                            idLength = Number( $newDivId.css( "width" ).replace( "px", "" ) );
                            
                            if ( first ) {
                                
                                for ( var k = 0; k < seq.length; k++ ) {
                                    
                                    if ( (k+1) % 10 === 0 || k === 0 ) {
                                        
                                        var $newDivRu = $( "<div><div/>" );
                                        $newDivRu.addClass( "divRu" );
                                        $newDivRu.html( "|" );
                                        $newDivRu.css( "left", ( leftStart + idLength + k * 11 + 5 ) + "px" );
                                        $newDivRu.css( "top", ( lineHeight * 2 + (itemSize + 3) * lineHeight * i ) + "px" );
                                        $content.append( $newDivRu );
                                        
                                        var $newDivLa = $( "<div><div/>" );
                                        $newDivLa.addClass( "divLa" );
                                        $newDivLa.html( count );
                                        $newDivLa.css( "left", ( leftStart + idLength + k * 11 + 5 ) + "px" );
                                        $newDivLa.css( "top", ( lineHeight * 1 + (itemSize + 3) * lineHeight * i ) + "px" );
                                        $content.append( $newDivLa );
                                        
                                    }
                                    
                                    count++;

                                }
                                
                                first = false;
                            
                            }
                            
                            for ( var k = 0; k < seq.length; k++ ) {
                                
                                var $newDivAA = $( "<div><div/>" );
                                $newDivAA.addClass( "divAA" );
                                $newDivAA.html( seq[k] );
                                $newDivAA.css( "left", ( leftStart + idLength + k * 11 + 5 ) + "px" );
                                $newDivAA.css( "top", ( lineHeight * ( j + 2 ) + (itemSize + 3) * lineHeight * i ) + "px" );
                                $newDivAA.attr( "aaType", seq[k] + "-c" );
                                $content.append( $newDivAA );
                                
                            }
                            
                        }
                        
                    }
                    
                }
                
                
                for ( var k = 0; k < alnSeq.length; k++ ) {

                    var $newDivSeq = $( "<div><div/>" );
                    $newDivSeq.addClass( "divSeq" );
                    $newDivSeq.html( alnSeq[k] );
                    $newDivSeq.css( "left", ( leftStart + idLength + k * 11 + 5 ) + "px" );
                    $newDivSeq.css( "top", ( lineHeight * (j+1) + (itemSize + 3) * lineHeight * i ) + "px" );
                    $content.append( $newDivSeq );

                }
                
            }
            
        }
        
        if ( data.length > 1 ) {
            $( "#waitMsg" ).hide();
            $( "#controls" ).show();
        }
        
    });
    
});

