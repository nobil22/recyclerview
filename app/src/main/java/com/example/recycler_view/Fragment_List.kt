package com.example.recycler_view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.databinding.DialogAddPersonBinding
import com.example.recycler_view.databinding.FragmentListBinding

class Fragment_List : Fragment() {

    lateinit var binding: FragmentListBinding
    var userDataList: MutableList<UserData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Initialize binding
        binding = FragmentListBinding.inflate(inflater, container, false)

        // Add items to the list
        addItemsToList()

        // Set up RecyclerView
        binding.myList.layoutManager = LinearLayoutManager(requireContext())
        binding.myList.adapter = UserDataAdaptor(userDataList) {
                itemlist->
             userDataList.remove(itemlist)
            binding.myList.adapter?.notifyDataSetChanged()
            // Navigate to details fragment with bundled data
            findNavController().navigate(
                R.id.fragment_Detalis,
                bundleOf(
                  "userdata" to itemlist
                )
            )
//            binding.butAdd.setOnClickListener {
//                showAddPersonDialog()
//            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    // Populate the list with sample data
    private fun addItemsToList() {
        userDataList.clear()
        userDataList.add(UserData(name = "Mohamed", phone = "01070650163", mail = "mohamed@gmail.com"))
        userDataList.add(UserData(name = "Nabil", phone = "01150650163", mail = "nabil@gmail.com"))
        userDataList.add(UserData(name = "Sahmeh", phone = "01070650163", mail = "sahmeh@gmail.com"))
        userDataList.add(UserData(name = "Mansour", phone = "01070650163", mail = "mansour@gmail.com"))
        userDataList.add(UserData(name = "Ali", phone = "01070650163", mail = "ali@gmail.com"))
    }
    private fun showAddPersonDialog() {
        val dialogBinding = DialogAddPersonBinding.inflate(layoutInflater)
        val dialogView = dialogBinding.root

        AlertDialog.Builder(requireContext())
            .setTitle("Add New Person")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = dialogBinding.editTextName.text.toString()
                val mail = dialogBinding.editTextMail.text.toString()
                val phone = dialogBinding.editTextPhone.text.toString()

                if (name.isNotEmpty() && mail.isNotEmpty() && phone.isNotEmpty()) {
                    val newPerson = UserData(name, mail, phone)
                    UserDataAdaptor.addPerson(newPerson)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
