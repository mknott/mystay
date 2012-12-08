<div class="modal_content">
   <div class="modal-title">Need Help?</div>
	<dl>
		<dt>Hotel Information</dt>
		<dd>
                  <b>Hotel Name:</b> ${propertyResult.hotelName}<br>
                  <b>Address:</b> ${propertyResult.address1} ${propertyResult.address2}<br>
                                  ${propertyResult.city}, ${propertyResult.state} 
                                  ${propertyResult.country}  ${propertyResult.postalCode}<br>
                  <b>Phone:</b> ${propertyResult.phoneNumber}<br>
                  <b>Fax:</b> ${propertyResult.faxNumber}<br>
                  <b>Reservations:</b> ${propertyResult.reservationsNumber}<br>
                  <b>Email Address:</b> ${propertyResult.email}<br>
                </dd>
	</dl>
	<dl>
		<dd>
                  Here are answers to some common questions.  Don't see what you need, 
                  <g:link url="[action:'index',controller:'roomService']" class="cta-blue ui-link modal-close"> 
                    start a new chat </g:link>
		</dd>
	</dl>
	<dl>
		<dt>Where is my food</dt>
		<dd>
		  Within 10 minutes after placing your order, the restaurant will confirm
                  the estimated delivery time.  We include this estimate in the receipt
                  that we email to you.  If that time has come and gone, please chat 
                  with us and we will find out where your food is.
		</dd>
	</dl>
	<dl>
		<dt>Can I change my order after I place it?</dt>
		<dd>
		  Maybe.  It depends on if the restaurant has started preparing
                  your food already.  The sooner you chat with us, the more likely
                  it will be that we can change your order.
		</dd>
	</dl>
	<dl>
		<dt>Did my order go through?</dt>
		<dd>
		  As soon as you click the "place my order" button, your order is 
                  sent to the restaurant.  We then message you a receipt when the
                  restaurant confirms an estimated delivery time, typically within 
                  10 minutes.
		</dd>
	</dl>
	<a href="#" class="cta-blue modal-close">close</a>
</div>