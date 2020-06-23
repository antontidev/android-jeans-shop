package android.upstarts.ui

import android.os.Bundle
import android.upstarts.App
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.upstarts.R
import android.upstarts.domain.interactors.GetJeansUseCase
import android.upstarts.ui.base.BaseFragment
import android.upstarts.util.adapter.CatalogAdapter
import android.upstarts.viewmodel.CatalogViewModel
import android.upstarts.viewmodel.CatalogViewModel_Factory
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_catalog.*
import kotlinx.android.synthetic.main.fragment_catalog.view.*
import javax.inject.Inject

class CatalogFragment : BaseFragment() {
    @Inject
    lateinit var catalogViewModel: CatalogViewModel

    lateinit var adapter: CatalogAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        adapter = CatalogAdapter {
            navigateToDetail(it)
        }

        view.catalogRv.adapter = adapter

        view.catalogRv.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

        catalogViewModel.jeans.observe(this.viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return view
    }

    private fun navigateToDetail(id: Long) {
        val action = CatalogFragmentDirections.actionCatalogFragmentToDetailFragment(id)

        findNavController().navigate(action)
    }
}