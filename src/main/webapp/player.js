/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


	var baseURL="http://localhost:8080/thevoz-phanzu-gamification/api/";
    
	
	function ViewModel(){
		var self=this;
		self.items=ko.observableArray(new Array());
		self.createItem=function(){
			return {
				id:0,
				firstName:'',
				lastName:'',
				email:'',
				numberOfPoints:0
			};
		}
		self.selected=self.createItem();
		//this.selected=ko.observable(this.selected);
		self.create =function (){
			//alert(self.name);
			$.ajax(
				baseURL+"/players",
				{
					headers:{apiKey:'k', apiSecret:'k'},
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
				baseURL+"/players",
				{
					headers:{apiKey:'k', apiSecret:'k'},
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
							var n=self.createItem();
							for(var p in n){
								var v=o.find(p);
								if(v)
									n[p]=v.text();
							}
							
							self.items.push(n);
						});

					}
				}
			);			
		}
	}
	
