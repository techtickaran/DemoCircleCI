package com.app.democircleci.ui.users

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.democircleci.R
import com.app.democircleci.data.model.Users
import com.app.democircleci.data.network.ListOfUsersAPI
import com.app.democircleci.data.repo.UserRepository
import kotlinx.android.synthetic.main.users_fragment.*


class UsersFragment : Fragment(),RecyclerviewItemClickListener {

    private lateinit var factory: UsersViewModelFactory

    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.users_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = ListOfUsersAPI()
        val repository = UserRepository(api)
        factory = UsersViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(UsersViewModel::class.java)
        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            recyclerviewUsers.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = usersadapter(users,this)
            }
        })
    }

    override fun onRecyclerItemClick(view: View, users: Users) {
       when(view.id){
           R.id.profile -> {
               Toast.makeText(requireContext(),users.name,Toast.LENGTH_SHORT).show()
           }
       }
    }

}
