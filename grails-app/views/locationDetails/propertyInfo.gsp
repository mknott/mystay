<div class="modal_content">
   <div class="modal-title">My Details</div>

      <p>
              <b>Guest:</b> ${myDetails.firstName} ${myDetails.lastName}<br>
              <b>Email:</b> ${myDetails.emailAddress} ${myDetails.emailAddress}<br>
              <b>Phone:</b> ${myDetails.mobileNumber} ${myDetails.mobileNumber}<br>
              <b>Reward Program #:</b> ${myDetails.rewardsProgramId}
      </p>
      <p>
              <b>Hotel Name:</b> ${myDetails.hotelName}<br>
              <b>Confirmation Number:</b> ${myDetails.confirmationId}<br>
              <b>Additional Reservation Details:</b><br>
              <b>Room #:</b> ${myDetails.roomNumber}<br>
              <b>Check-in:</b> ${myDetails.checkInDate}<br>
              <b>Check-out:</b> ${myDetails.checkOutDate}<br>
      </p>
      <p>
              <b>MyStay Chats:</b> ${myDetails.myChats}
      </p>
      <p>
              <g:link url="[action:'index',controller:'newProfile']" class="cta-blue ui-link modal-close"> Update my information </g:link>
      </p>
      <!-- <p>
              <a href="" class="cta-blue modal-close">close</a>
      </p>-->
  </div>
</div>
