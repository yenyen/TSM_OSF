/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


	var baseURL="api";
    $('#json').click(function(){ 
        alert('json');
         $.getJSON(baseURL+"/applications",
         function(data) {
            alert(data);         
          });   
    });

    $('#ajax').click(function(){ 
        alert('ajax');
         $.ajax({ 
             type: "GET",
             dataType: "json",
             url: baseURL+"/applications",
             success: function(data){        
                alert(data);
             }
         });
    });

    $('#ajax_xml').click(function(){ 
        alert('ajax+xml');
         $.ajax({ 
             type: "GET",
             dataType: "xml",
             url: baseURL+"/applications",
             success: function(data){        
                //alert(data);
				alert($(data).val());
             }
         });
    });
	
	function ViewModel(){
		var self=this;
		this.items=ko.observableArray(new Array());
		this.selected={
			id:0,
			name:"",
			description:"",
			apiKey:"",
			apiSecret:""
		};
		//this.selected=ko.observable(this.selected);
		self.create =function (){
			//alert(self.name);
			$.ajax(
				baseURL+"/applications",
				{
					data:ko.toJSON(self.selected),
					type:"post", contentType: "application/json",
					success: function(result) { 
						//alert(result) 
						self.load();
					}
				}
			);
		}
		self.load=function(){
			$.ajax(
				baseURL+"/applications",
				{
					type:"get", contentType: "application/json",
					success: function(result) { 
						//var x=new XMLHttpRequest();
						//x.responseXML.childNodes.
						//var l=result.firstChild.childNodes;
						//alert(l.length);
						//self.items=new Array();
						self.items.removeAll();
						//<?xml version="1.0" encoding="UTF-8" standalone="yes"?><publicApplicationTOes><publicApplicationTO><id>1</id><apiSecret>******</apiSecret><description>2</description><name>1</name></publicApplicationTO><publicApplicationTO><id>2</id><apiSecret>******</apiSecret><description>2</description><name>1</name></publicApplicationTO><publicApplicationTO><id>3</id><apiSecret>******</apiSecret><description>2</description><name>1</name></publicApplicationTO></publicApplicationTOes>
						$(result).find('publicApplicationTO').each(function(){
							var m=this;
							var o=$(m);
							var n={
								id:o.find("id").text(),
								name:o.find("name").text(),
								description:o.find("description").text(),
								apiKey:o.find("apiKey").text(),
								apiSecret:o.find("apiSecret").text(),
							};
							//alert(n.id);
							self.items.push(n);
						});

					}
				}
			);			
		}
	}
	
