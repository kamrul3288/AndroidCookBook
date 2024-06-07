package com.iamkamrul.tpl.signalr

import android.os.Bundle
import com.iamkamrul.tpl.databinding.FragmentSignalrBinding
import com.iamkamrul.ui.base.BaseFragment
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder
import com.microsoft.signalr.HubConnectionState
import timber.log.Timber


class SignalrFragment : BaseFragment<FragmentSignalrBinding>() {
    override fun viewBindingLayout(): FragmentSignalrBinding  = FragmentSignalrBinding.inflate(layoutInflater)

    private lateinit var hubConnection: HubConnection

    override fun initializeView(savedInstanceState: Bundle?) {
        buildConnection()
        setConnectionStatus("INITIAL")

        binding.startConnectionBtn.setOnClickListener {
            startHubConnection(
                success = {
                    setConnectionStatus("CONNECTED")
                    showToast(it)
                    listenPaymentSuccess()
                },
                failed = {
                    setConnectionStatus("FAILED")
                    showToast(it)
                }
            )
        }
    }

    private fun listenPaymentSuccess(){
        hubConnection.on("ReceivePaymentConfirm",{
            requireActivity().runOnUiThread {
                setConnectionStatus("PAYMENT SUCCESS")
            }
        },String::class.java)
    }


    private fun buildConnection(){
        hubConnection = HubConnectionBuilder.create("http://18.136.212.176:5000/PaymentHub")
            .build()
    }

    private fun startHubConnection(success:(String)->Unit, failed:(String)->Unit){
        setConnectionStatus("CONNECTING")
        // start the connection
        hubConnection.start().blockingAwait()
        if (hubConnection.connectionState ==  HubConnectionState.CONNECTED){
            val connectionId = hubConnection.connectionId
            success(connectionId)
            Timber.e(connectionId)
            return
        }

        failed("Connection failed. Please try again.")
    }

    private fun setConnectionStatus(status:String){
        binding.connectionStatusTv.text = "Status: $status"
    }

}
