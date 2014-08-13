/* 
 * Author: David Buzatto
 */

$( function() {
    
    $.ajaxPrefilter( "json script", function( options ) {
        options.crossDomain = true;
    });
    
    $( "#colorScheme" ).change( function( evt ) {
        
        var sufix = $( "#colorScheme" ).val();
        
        $( ".spanAA" ).each( function( ind, ele ){
            $( ele ).attr( "aaType", $( ele ).html() + "-" + sufix );
        });
        
    });
    
    $.getScript( "data.js", function( d, ts, jqXHR ) {
        
        var $content = $( "#contentTable" );
        var count = 1;
        var countSeq = [];
        
        for ( var i = 0; i < data.length; i++ ) {
            
            var sec = data[i].sec;
            
            if ( sec !== null ) {
                
                var alnSeq;
                var itemSize = sec.length;
                var first = true;
                
                for ( var j = 0; j < itemSize; j++ ) {
                    
                    var item = sec[j];
                    
                    var id = item.id;
                    var seq = item.seq;
                    
                    if ( id !== null ) {
                            
                        if ( id === "aln" ) {
                            alnSeq = seq;
                        } else {
                            
                            if ( first ) {
                                
                                var $newRowHeaderAAN = $( "<tr></tr>" );
                                $newRowHeaderAAN.append( "<td></td><td></td><td id='headerAAN-" + i + "-" + j + "'></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>" );
                                $content.append( $newRowHeaderAAN );
                                
                                var $newRowHeaderRu = $( "<tr></tr>" );
                                $newRowHeaderRu.append( "<td></td><td></td><td id='headerRu-" + i + "-" + j + "'></td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>" );
                                $content.append( $newRowHeaderRu );
                                
                                var $headerAAN = $( "#headerAAN-" + i + "-" + j );
                                var $headerRu = $( "#headerRu-" + i + "-" + j );
                                
                                for ( var k = 0; k < seq.length; k++ ) {
                                    
                                    if ( (k+1) % 10 === 0 || k === 0 || k === seq.length - 1  ) {
                                        
                                        var $newSpanAAN = $( "<span></span>" );
                                        $newSpanAAN.addClass( "spanAAN" );
                                        $newSpanAAN.html( count );
                                        $headerAAN.append( $newSpanAAN );
                                        
                                        var $newSpanRu = $( "<span></span>" );
                                        $newSpanRu.addClass( "spanRu" );
                                        $newSpanRu.html( "|" );
                                        $headerRu.append( $newSpanRu );
                                        
                                    } else {
                                        
                                        var $newSpanAAN = $( "<span></span>" );
                                        $newSpanAAN.addClass( "spanAAN" );
                                        $newSpanAAN.html( "&nbsp;" );
                                        $headerAAN.append( $newSpanAAN );
                                        
                                        var $newSpanRu = $( "<span></span>" );
                                        $newSpanRu.addClass( "spanRu" );
                                        $newSpanRu.html( "&nbsp;" );
                                        $headerRu.append( $newSpanRu );
                                        
                                    }
                                    
                                    count++;

                                }
                                
                                first = false;
                            
                            }
                            
                            var $newRowId = $( "<tr></tr>" );
                            var $newColumnId = $( "<td></td>" );
                            $newColumnId.addClass( "cryId" );
                            $newColumnId.html( id );
                            $newRowId.append( $newColumnId );
                            $newRowId.append( "<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='seq-" + i + "-" + j + "'></td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='count-" + i + "-" + j + "'></td>" );
                            $content.append( $newRowId );
                            
                            var $columnSeq = $( "#seq-" + i + "-" + j );
                            var $columnSeqCount = $( "#count-" + i + "-" + j );
                            
                            for ( var k = 0; k < seq.length; k++ ) {
                                
                                var $newSpanAA = $( "<span></span>" );
                                $newSpanAA.addClass( "spanAA" );
                                $newSpanAA.html( seq[k] );
                                
                                if ( seq[k] !== "-" ) {
                                    if ( countSeq[id] ) {
                                        countSeq[id] = countSeq[id] + 1;
                                    } else {
                                        countSeq[id] = 1;
                                    }
                                }
                                
                                $newSpanAA.attr( "aaType", seq[k] + "-c" );
                                $columnSeq.append( $newSpanAA );
                                
                            }
                            
                            $columnSeqCount.html( countSeq[id] );
                            
                        }
                        
                    }
                    
                }
                
                var $newRowAlnSeq = $( "<tr></tr>" );
                $newRowAlnSeq.append( "<td></td><td></td><td id='alnSeq-" + i + "-" + j + "'></td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>" );
                $content.append( $newRowAlnSeq );
                
                var $columnAlnSeq = $( "#alnSeq-" + i + "-" + j );
                
                for ( var k = 0; k < alnSeq.length; k++ ) {

                    var $newSpanAlnSeq = $( "<span></span>" );
                    $newSpanAlnSeq.addClass( "spanAlnSeq" );
                    if ( alnSeq[k] === " " ) {
                        $newSpanAlnSeq.html( "&nbsp;" );
                    } else {
                        $newSpanAlnSeq.html( alnSeq[k] );
                    }
                    $columnAlnSeq.append( $newSpanAlnSeq );

                }
                
                var $newRowBlank = $( "<tr></tr>" );
                $newRowBlank.append( "<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td></td>" );
                $content.append( $newRowBlank );
                
            }
            
        }
        
        if ( data.length > 1 ) {
            $( "#waitMsg" ).hide();
            $( "#controls" ).show();
        }
        
    });
    
});

